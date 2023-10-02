package com.example.aws.sqs.starter.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AwsSqsStarterExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsSqsStarterExampleApplication.class, args);
    }

}
