package com.tsystems.mms.pf23.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Marco Grunert (marco.grunert@t-systems.com)
 */
@SpringBootApplication
@EnableScheduling
public class MailerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailerApplication.class);
    }
}
