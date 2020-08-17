package io.github.arthurrmoura;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class EcommerceConsumerApp {
	
    public static void main(String[] args) {
        SpringApplication.run(EcommerceConsumerApp.class, args);
    }
}