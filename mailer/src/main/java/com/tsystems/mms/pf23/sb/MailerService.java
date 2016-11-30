package com.tsystems.mms.pf23.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @author Marco Grunert (marco.grunert@t-systems.com)
 */
@Component
public class MailerService {
    private Logger logger = LoggerFactory.getLogger(MailerApplication.class);

    @Scheduled(fixedDelayString = "${process.interval:5000}", initialDelay = 5000)
    public void processSubscriptions() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Subscriber[]> subscribers =
                restTemplate.getForEntity("http://localhost:8001/subscribers", Subscriber[].class);

        for (Subscriber subscriber : subscribers.getBody()) {
            logger.info(subscriber.toString());
        }
    }
}
