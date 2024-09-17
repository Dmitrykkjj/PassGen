package org.example.passgen;

import org.example.passgen.annotations.EnableLoggingFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLoggingFilter
public class PassGenApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassGenApplication.class, args);
    }
}
