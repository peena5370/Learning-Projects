# Methods of using Git command
![img](../Pictures/git-img.jpg)
Source:[Git教程](https://www.yiibai.com/git/git_remote_operate.html)
## 1.0 Install git with terminal for Linux
```bash
> sudo apt-get install git
```

## 2.0 Check git version
```bash
> git --version
```

## 3.0 Git configuration
1. Configure username and email for git 
```bash
> git config --global user.name "User Name"
> git config --global user.email "usermail123@gmail.com"
```
2. Showing all Git setting
```bash
> git config --list
core.......
user.email=abcdefg123@gmail.com
user.name=abcdefg
......
```
3. Showing overall git config
```bash
> git help config
......
```


## 4.0 Create a SSH key for local computer and own repository
1. Create SSH key with ssh-keygen
```bash
> ssh-keygen -t rsa -C "usermail123@gmail.com"
```
2. Later terminal will prompted a message to specify a file location to save the key, to save at default file location, continue by pressing "Enter" button to accept the default file location.
3. Next, the terminal will prompt to ask for a secure passphrase, if want to leave it empty, press "Enter" button to move forward.
4. At this point, a new SSH key will have generated at the terminal and save inside the file that previously specified.
5. For checking SSH key for ensuring ssh-agent is running, simply type below command
```bash
> eval "$(ssh-agent -s)"
Agent pid 123456
```
6. Once ssh-agent is running, run the following command to add new SSH key to the local SSH agent
```bash
> ssh-add -K "local file path that previously save the SSH key"

# for Windows
> ssh-add "local file path that previously save the SSH key"
```

## 5.0 Create an online repository at Github
1. At first, login into Github, and then go to Setting > SSH and GPG keys
2. Create a new SSH key for authenticaion purpose
3. Copy the SSH key that created just now at local computer and add it to Github
4. After that, create a new repository at Github
5. After successing created a new reposiroty, copy the SSH address for later use

## 6.0 Initialize Git functions at local project
1. Locate the project file directory by using "cd" command, and then input the following command at the terminal:
```bash
> cd "/User/filedir/project/demo"
> git init
```
2. Connect local repository with the remote repository
```bash
> git remote add origin git@github.com:user/github-dir.git
```
3. Making a pull requst from remote repository to make it synchronized with local repository
```bash
> git pull
```
4. If the newly created remote repository is empty, simply type the following command for add all the file and commit it to Github reposiroty
```bash
> git add .
> git commit -m "add base files"
```
5. Add an upstream for local master repository
```bash
> git branch --set-upstream-to=origin/master master
```
6. If the message "fatal: refusing to merge unrelated histories" exist on the terminal during pull and push request, type in the below command:
```bash
> git pull --allow-unrelated-histories
```

## Notes:
1. Pull request: download remote repository to local repository
```bash
> git pull
```
2. Push request: publish local repository to remote repository
```bash
> git push origin <branch_name>
```
3. Showing all branches
```bash
# Showing remote branch
> git branch -r
origin/master

# Showing local and remote branch
> git branch -a
* master
  remotes/origin/master
```
4. Checking git status
```bash
> git status
```
5. Add all files to remote repository
```bash
> git add . # Or maybe git add /filepath/filename.txt
```
6. Commit the file to remote repository
```bash
> git commit -m "add new file to directory"
```
7. Create a new branch
```bash
> git checkout -b branch_name
```
8. Switch to main branch
```bash
> git checkout master
```
9. Merge the changes in branch_name to main branch
```bash
> git merge branch_name
```
10. Cloning/ pull a repository to local computer
```bash
> cd # 'file-directory'
> git clone githubhttps_url
```
11. For cloning a Github repository which protected by SSH, please use SSH url to clone the project repository
12. View repository log info
```bash
> git log
commit e377657056f4ea87c8fa2f40b7653b9ffdc775f5 (HEAD -> master, origin/master)
Author: accountname <abcdef123@gmail.com>
Date:   Fri Jan 15 12:34:55 2023 +0800

    Message status one

commit a355d5f734b497c11237b63995a0e222af01c3b2
Author: accountname <abcdef123@gmail.com>
Date:   Fri Jan 15 14:34:55 2023 +0800

    Message status two
```
13. Showing selected commit detail message
```bash
> git show a355d5f734b497c11237b63995a0e222af01c3b2
commit a355d5f734b497c11237b63995a0e222af01c3b2
Author: accountname <abcdef123@gmail.com>
Date:   Fri Jan 15 14:34:55 2023 +0800

    Message status two

...... # will have more details here
```
14. Review changes of selected file
```bash
> git diff <filename>
diff --git a/filename b/filename
index .....
--- a/filename
+++ b/filename
.....'Will have more details here.'
# The line with "-" indicate deleted content, "+" indicate added content.
```
15. Move file to another directory
```bash
> pwd
/usr/source/dir/example
> ls
README.md demo.java
> mkdir src
> git mv demo.java src/
> git status
On branch master
......

Changes to be commited:

    renamed: demo.java -> src/main.java

Changes not staged for commit:

    modified src/demo.java

> git add .
> git commit -m "Modify directory structure"
....
> git push origin master
....
```
16. Rename file
```bash
> git mv demo.java demo1.java
> git status -s
# "R" here indicates file has been renamed
R demo.java -> demo1.java
> git commit -a -m 'Remane demo.java to demo1.java'
......
> git push origin master
......
```
17. Delete file
```bash
> git rm demo1.java
rm 'demo1.java'
> git commit -a -m 'Delete demo1.java'
......
> git push origin master
...... 
```
18. Adding tag for released update
```bash
> git tag -a 'Release_1_0' -m 'Tagged the repository' a355d5f734b497c11237b63995a0e222af01c3b2
> git push origin tag Release_1_0
.....

* [new tag]        Release_1_0 -> Release_1_0
```
19. Checking available tag
```bash
> git pull
.....

* [new tag]       Release_1_0 -> Release_1_0

> git tag -l
Release_1_0
```
20. Show tag detail messages
```bash
> git show Release_1_0
......

diff ......
.....
```
21. Delete tag
```bash
> git tag
Release_1_0

> git tag -d Release_1_0
Deleted tag 'Release_1_0' (was db23f1e)

> git push origin :Release_1_0
.....

- [deleted]       Release_1_0
```
22. Initialize Git repository(git init won't replace available files in the directory)
```bash
> cd /usr/path/newexample
> git init                        # Create a /usr/path/newexample/.git directory
> git add .                       # adding all files
> git commit -m "Commit message"  # commit files to repository
```
## Managing and monitoring remote branch
1. List available remote branch
```bash
> git remote
origin
```
2. List details of available remote branch
```bash
> git remote -v
origin http:............git (fetch)
origin http:............git (push)

>git remote --verbose
origin http:............git (fetch)
origin http:............git (push)
```
3. Adding new remote branch
```bash
> git remote
origin
> git branch -r
origin/main
origin/master
> git remote add staging git..............git
> git remote
origin
staging
> git fetch staging
...
*  [new branch]   main    -> staging/main
*  [new branch]   master  -> staging/master
> git branch -r
origin/main
origin/master
staging/main
staging/master
> git checkout -b staging staging/master
...
Switched to a new branch 'staging'
```
