package com.sparta.hanghaestartproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HanghaeStartProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HanghaeStartProjectApplication.class, args);
        System.out.println("args = " + args);
        System.out.println("args = " + args);
        System.out.println("args = " + args);
        System.out.println("args = " + args);
        System.out.println("args = " + args);
    }

}
