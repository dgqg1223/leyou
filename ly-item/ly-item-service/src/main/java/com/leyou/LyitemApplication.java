package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.leyou.item.web")
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.leyou.item.mapper")
public class LyitemApplication {
    public static void main(String[] args) {

        SpringApplication.run(LyitemApplication.class,args);
    }
}
