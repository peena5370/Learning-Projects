### Local Jenkins installation on Windows
1. Enable and install WSL2 with ubuntu distro
2. Open WSL2 with "Open as Administrator" rights
3. Install java jdk17 (Obsoleted on March 2026 for Jenkins to support on jdk 17)
```shell
> sudo apt update &7 sudo apt upgrade -y
# install openjdk17
> sudo apt install openjdk-17-jdk -y
```
4. Add Jenkins repository into apt 
```shell
> curl -fsSL https://pkg.jenkins.io/debian/jenkins.io-2023.key | sudo tee /usr/share/keyrings/jenkins-keyring.asc > /dev/null
> echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] https://pkg.jenkins.io/debian-stable binary/ | sudo tee /etc/apt/sources.list.d/jenkins.list > /dev/null
# update apt repository
> sudo apt update
```
5. Install Jenkins
```shell
> sudo apt install jenkins -y
```
6. Enable Jenkins to start during service start
```shell
> sudo systemctl enable Jenkins
> sudo systemctl start Jenkins
 # if service is started, then Jenkins has been success installed inside WSL
> sudo systemctl status Jenkins
```
7. Access Jenkins from Windows
- Check WSL IP address
```shell
# can use the ip address to access Jenkins portal at Windows browser
> hostname -I 
# {will have bunch of IP addresses shown here}
```
- Use the above IP address or can use http://localhost:8080 from Windows browser to access Jenkins
8. get Jenkins initial password and login into Jenkins
```shell
> sudo cat /var/lib/jenkins/secrets/initialAdminPassword
# {will have a random string output here}
```
> - Copy that value and use during Jenkins setup(please keep it if later you still want to use the admin account in Jenkins)
> - Install suggested plugins
> - Create user
> - Configure Jenkins url(set it as httpL..localhost:8080)
9. Configure Jenkins with connecting to GitHub private repository (using SSH key)
- Inside wsl, generate SSH key
```shell
> ssh-keygen -t ed25519 -C "github_email@example.com"
```
- Save the key and assign the key to Jenkins
```shell
> sudo mkdir -p /var/lib/jenkins/.ssh
> sudo cp ~/.ssh/id_ed25519* /var/lib/jenkins/.ssh/
> sudo chown -R jenkins:jenkins /var/lib/jenkins/.ssh
> sudo chmod 600 /var/lib/jenkins/.ssh/id_ed25519
```
- Copy the public key and set it at GitHub(at GitHub Settings > SSH and GPG Keys > New SSH Key(name whatever key name you want))
```shell
> cat /var/lib/jenkins/.ssh/id_ed25519.pub 
# {will display the public key string here}
```
- Copy private key into Jenkins
```shell
> cat /var/lib/jenkins/.ssh/id_ed25519
# {will display the private key, need it inside the Jenkins later}
```
- open Jenkins > Manage Jenkins > Credentials > System > Global credentials (unrestricted) > Add Credentials
> - Kind = SSH Username with private key
> - ID = put whatever you want
> - Username = git
> - Tick Enter directly and click Add for adding the private key which copied just now

### Install Docker in WSL
1. Install the required package
```shell
> sudo apt update
> sudo apt install -y ca-certificates curl gnupg lsb-release
```
2. If hit with "gpg: conflicting command" inside WSL, execute below command to reinstall gpg(for ubuntu 24.04)
```shell
> sudo apt remove -y gpgv
> sudo apt install -y gpg
# check for gpg installed version
> gpg --version
```
3. Add Docker repository
```shell
> sudo mkdir -m 0755 -p /etc/apt/keyrings
> curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
> echo "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
```
4. Install Docker and Docker compose
```shell
> sudo apt update
> sudo apt install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```

### Add Jenkins job and link the job with GitHub private repository
1. Run ssh command to let Jenkins recognizing the GitHub(login as Jenkins in wsl with "sudo su Jenkins")
2. Add GitHub hostkey to Jenkins known host
```shell
> sudo -u jenkins ssh-keyscan -t rsa,ecdsa,ed25519 github.com >> /var/lib/jenkins/.ssh/known_hosts
> sudo chown jenkins:jenkins /var/lib/jenkins/.ssh/known_hosts
> sudo chmod 644 /var/lib/jenkins/.ssh/known_hosts
> ssh git@github.com
# {if see this "Are you sure you want to continue connecting (yes/no)?" input yes and your Jenkins will recognize GitHub after this}
```

### Setting up project with support to deploy to Docker container
1. create a Dockerfile and put at project root directory
2. create a Jenkinsfile(use for Jenkins cicd pipeline)
- Jenkinsfile
```json
pipeline {
    agent any

    environment {
        PATH = "/usr/libexec/docker/cli-plugins:${env.PATH}"
    }

    stages {
        stage('Check Docker') {
            steps {
                sh 'echo $PATH'
                sh 'which docker'
                sh 'docker buildx version'
                sh 'docker compose version'
            }
        }
        stage('Checkout') {
            steps {
                // The Git plugin automatically checks out the code
                // This stage is here to make the process explicit
                echo 'Checking out code from Git...'
                checkout scm
            }
        }
        
        stage('Build Docker Image') {
            steps {
                echo 'Building and starting services with Docker Compose...'
                // This command reads your docker-compose.yml file, builds the images,
                // and starts all the defined services in the background (-d).
                sh 'docker build -t {project-name} .'
            }
        }

        stage('Run Tests') {
            when {
                expression { fileExists('tests') }
            }
            steps {
                echo "Running pytest inside container..."
                sh 'docker run --rm {project-name} pytest --maxfail=1 --disable-warnings --allow-no-test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Starting services with Docker Compose...'
                sh 'docker compose up -d --build'
            }
        }

        stage('Clean Up') {
            steps {
                echo 'Pruning unused Docker images and containers...'
                sh 'docker system prune -f'
            }
        }
    }
}
```
3. Create docker-compose.yaml(which is use for setting up docker environment variables)
```yaml
version: '3.9'

services:
  {project-name}:
    # Builds the Docker image from the Dockerfile in the current directory
    build: .
    # {hostPort}:{containerPort} the host port is the exposed port to the endpoint and containerPort is the value for the project use
    ports:
      - "12010:5353"
    env_file:
    - .env.docker
    volumes:
      - ./logs:/var/log/app   # IMPORTANT: map host logs folder into container
    logging:
      driver: "json-file"
      options:
        max-size: "10m"
        max-file: "3"
```

#### For debugging Docker and images status
1. Check for docker container status
```shell
> docker ps
CONTAINER ID   IMAGE                                       COMMAND                  CREATED              STATUS              PORTS                                           NAMES
f7f9f6bf8599   {imageName}   "/bin/sh -c 'uvicorn…"   About a minute ago   Up About a minute   0.0.0.0:12010->5353/tcp, [::]:12010->5353/tcp   {containerName}
```
2. Exposing windows database to be accessible by Docker container
- Confirm <b>[bind-address=0.0.0.0]</b> inside <b>my.ini/my.cnf</b> is setup
- Create database user that can connect by remote in mysql/mariadb
```sql
CREATE USER 'useraccount'@'%' IDENTIFIED BY 'Password@1234';
GRANT ALL PRIVILEGES ON *.* TO 'useraccount'@'%';
FLUSH PRIVILEGES;
```
- check on accessibility from WSL to Windows using below command(if it throw connection refused or didn't throw anything, go for next step)
```shell
# execute below command in WSL
> nc -zv localhost 3306 / nc -zv 192.168.123.234 3306
```
- at PowerShell at Windows(administrator login), execute below command
```shell
> netsh advfirewall firewall add rule name="MariaDB 3310" dir=in action=allow protocol=TCP localport=3306
```
- open port for 3306(Windows Defender Firewall > Advanced Settings > Inbound Rules > New Rule > Port > TCP 3306 > Allow)
- Re-test again the connection at WSL
```shell
> nc -zv localhost 3306 / nc -zv 192.168.123.234 3306
# {if return "Connection to <LAN_IP> 3310 port [tcp/*] succeeded!", means able to connect to windows database from wsl already}
```
<strong>IMPORTANT***</string>
- <b>use host.docker.internal as the database host value inside your application/configuration properties for the database host value for your project</b>

### Setup ELK/EFK stacks in WSL(with filebeat or using fluentbit as log shipper for elasticsearch) with Kibana v7.17
1. Update memory before installing ELK
```shell
# set the kernel setting now
> sudo sysctl -w vm.max_map_count=262144
# to persist it across reboots, add to /etc/sysctl.conf
> echo "vm.max_map_count=262144" | sudo tee -a /etc/sysctl.conf
```
2. Create files that use for ELK
- docker-compose.elk.yml
```yaml
version: '3.8'

services:
  elasticsearch:
    image: docker.elastic.co/elasticsearch/elasticsearch:7.17.13
    container_name: es-node
    environment:
      - node.name=es01
      - cluster.name=es-docker-cluster
      - discovery.type=single-node
      - bootstrap.memory_lock=true
      - ES_JAVA_OPTS=-Xms1g -Xmx1g
    ulimits:
      memlock:
        soft: -1
        hard: -1
    volumes:
      - esdata:/usr/share/elasticsearch/data
    ports:
      - "9200:9200"

  kibana:
    image: docker.elastic.co/kibana/kibana:7.17.13
    container_name: kibana
    environment:
      - ELASTICSEARCH_HOSTS=http://elasticsearch:9200
    ports:
      - "5601:5601"
    depends_on:
      - elasticsearch

#  filebeat:
#    image: docker.elastic.co/beats/filebeat:7.17.13
#    container_name: filebeat
#    user: root
#    volumes:
#      - ~/elk-config/filebeat.yml:/usr/share/filebeat/filebeat.yml:ro
      # mount your app logs folder (read-only), directory format would be: {container log directory to get from}:{destination directory}
#      - /var/lib/jenkins/workspace/{projectName}/logs:/var/log/app:ro  # IMPORTANT: need check the filepath to allow fluent-bit to get log from
#    depends_on:
#      - elasticsearch

# use fluentbit if for microservice, and can use filebeat if wanna have more customize on logging, but it will consume more resources
  fluent-bit:
    image: fluent/fluent-bit:2.2
    container_name: fluent-bit
    volumes:
      - ~/elk-config/fluent-bit.conf:/fluent-bit/etc/fluent-bit.conf
      - ~/elk-config/parsers.conf:/fluent-bit/etc/parsers.conf
      - /var/lib/jenkins/workspace/{projectName}/logs:/var/log/app:ro # IMPORTANT: need check the filepath to allow fluent-bit to get log from
    depends_on:
      - elasticsearch

volumes:
  esdata:
- filebeat.yml(if use filebeat as log shipper tool, please choose either 1 file shipper tool among both)
filebeat.inputs:
  - type: log
    enabled: true
    paths:
      - /var/log/app/*.log
    fields:
      service: {serviceName}

processors:
  - add_host_metadata: ~
  - add_cloud_metadata: ~

output.elasticsearch:
  hosts: ["http://elasticsearch:9200"]

setup.kibana:
  host: "kibana:5601"
```
- fluent-bit.conf(for Fluentbit)
```text
[SERVICE]
    Flush         1
    Daemon        Off
    Log_Level     info
    Parsers_File  parsers.conf

# Input: Tail logs from app container
[INPUT]
    Name              tail
    Path              /var/log/app/*.log
    Parser            app_json
    Tag               payroll-core-service
    Refresh_Interval  5
    Mem_Buf_Limit     10MB
    Skip_Long_Lines   On
    DB                /var/log/flb_tail.db
    multiline.parser  multiline_java

# Filter: Add service field
[FILTER]
    Name    modify
    Match   {serciveName}
    Add     service {serviceName}

# Output: Send directly to Elasticsearch
[OUTPUT]
    Name  es
    Match *
    Host  elasticsearch
    Port  9200
    Index fluentbit-logs
    Type  _doc
```
- parsers.conf(for Fluentbit)
```text
[PARSER]
    Name        app_json
    Format      json
    Time_Key    time
    Time_Format %Y-%m-%d %H:%M:%S
    Time_Keep   On

# Example multiline (adjust for Python/FastAPI if needed)
[MULTILINE_PARSER]
    Name          multiline_java
    Type          regex
    Flush_Timeout 1000
    Rule      "start_state"   "^\d{4}-\d{2}-\d{2}"   "cont"
    Rule      "cont"          "^(?!\d{4}-\d{2}-\d{2}).*"   "cont"
```
2. Copy those files and place in WSL native filesystem
- make elk directory and copy those files into the elk directory
```shell
> mkdir -p ~/elk-config
# change permission for filebeat file
> sudo chown root:root ~/elk-config/filebeat.yml
> sudo chmod 644 ~/elk-config/filebeat.yml
```

#### For debugging ELK related
- Restart ELK docker compose
```shell
> docker compose -f docker-compose.elk.yml down
> docker compose -f docker-compose.elk.yml up -d
```
- For close and remove old elasticsearch container
```shell
> docker stop {elasticSearchContainerName} kibana
> docker rm {elasticSearchContainerName} kibana
```
- Stop filebeat container
```shell
> docker stop filebeat
> docker rm filebeat
```
- List all containers
```shell
> docker ps -a
```
- Stop all containers
```shell
> docker stop $(docker ps -aq)
> docker rm $(docker ps -aq)
```
- Stop everything related with docker compose
```shell
> docker-compose down
# rebuild and start fresh
> docker-compose up -d
```
- Access docker container with shell and printing the log
```shell
> docker exec -it {containerServiceName} sh
> cat /var/log/app/app.log
```
- Console log that made into elasticsearch
```shell
> curl "http://localhost:9200/filebeat-*/_search?q=your-log-message&pretty"
```
- Test for elasticsearch status
```shell
> curl http://localhost:9200
{
  "name" : "elasticsearch",
  "cluster_name" : "docker-cluster",
  "cluster_uuid" : "...",
  "version" : {
    "number" : "7.17.x",
    ...
  },
  "tagline" : "You Know, for Search"
}
```
- Check for both containers should mount to same directory
```shell
> docker inspect filebeat | grep /var/log/app
> docker inspect {containerServiceName} | grep /var/log/app
```