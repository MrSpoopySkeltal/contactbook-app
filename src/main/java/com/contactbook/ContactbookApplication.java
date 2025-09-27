package com.contactbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = {
    "com.example",
	"com.controller",
    "com.model",
    "com.service",
    "com.repository",
    "com.aspect"

})
@EnableJpaRepositories("com.repository")
@EntityScan("com.model")
@EnableAspectJAutoProxy
public class ContactbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactbookApplication.class, args);
    }
}
