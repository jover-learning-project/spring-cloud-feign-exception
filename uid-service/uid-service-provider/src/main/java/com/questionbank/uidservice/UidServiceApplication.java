package com.questionbank.uidservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@EnableFeignClients
@SpringBootApplication
public class UidServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UidServiceApplication.class, args);
    }

}
