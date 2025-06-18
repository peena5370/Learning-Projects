package com.elibrarian.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EntityScan("com.elibrarian.demo.model")// scan entity packages
//@EnableJpaRepositories(basePackages= {"com.elibrarian.demo.repos"}) // scan repositories packages
@EnableJpaAuditing
@EnableTransactionManagement
@SpringBootApplication
public class SpringBootElibrarianApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootElibrarianApplication.class, args);
    }

}
