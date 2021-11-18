package org.rutgers.imperative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@ComponentScan("org.rutgers")
public class ImperativeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImperativeApplication.class, args);
    }
}
