package com.walmart.finance.ap.fds.purging.cron.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Configuration
public class PurgePocMain {
    public static void main(String[] args) {
        SpringApplication.run(PurgePocMain.class, args);
    }
}
