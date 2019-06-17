package com.leyou;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class LyUploadApplcation {
    public static void main(String[] args) {
        SpringApplication.run(LyUploadApplcation.class);
    }
}
