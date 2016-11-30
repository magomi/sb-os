package com.tsystems.mms.pf23.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author Marco Grunert (marco.grunert@t-systems.com)
 */
@SpringBootApplication
public class MailerApplication {

    private Logger logger = LoggerFactory.getLogger(MailerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MailerApplication.class);
    }

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            ResponseEntity<Subscriber[]> subscribers = restTemplate
                    .getForEntity("http://localhost:8001/subscribers", Subscriber[].class);

            for (Subscriber subscriber : subscribers.getBody()) {
                logger.info(subscriber.toString());
            }
        };
    }
}
