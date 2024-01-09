package com.sampleapp.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients( basePackages = "com.sampleapp.clients")
@SpringBootApplication(
        scanBasePackages = {
                "com.sampleapp.customer",
                "com.sampleapp.amqp"
        }
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication .run(CustomerApplication.class, args);
    }
}
