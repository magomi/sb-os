package com.tsystems.mms.pf23.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Marco Grunert (marco.grunert@t-systems.com)
 */
@Component public class MailerService {
    private Logger logger = LoggerFactory.getLogger(MailerApplication.class);

    @Autowired JavaMailSender mailSender;

    @Autowired SpringTemplateEngine templateEngine;

    @Value("${mail.fromaddress}") private String fromAddress;

    @Value("${mail.subject}") private String subject;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Scheduled(fixedDelayString = "${process.interval:5000}", initialDelay = 5000) public void processSubscriptions() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Subscriber[]> subscribers = restTemplate
                .getForEntity("http://localhost:8001/subscribers", Subscriber[].class);

        for (Subscriber subscriber : subscribers.getBody()) {

            try {
                final Context ctx = new Context(Locale.ENGLISH);
                ctx.setVariable("name", subscriber.getName());
                ctx.setVariable("date", sdf.format(new Date()));

                final String htmlContent = templateEngine.process("template", ctx);

                final MimeMessage mimeMessage = mailSender.createMimeMessage();
                final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
                message.setFrom(fromAddress);
                message.setTo(subscriber.getEmail());
                message.setSubject(subject + " " + sdf.format(new Date()));
                message.setText(htmlContent, true);
                this.mailSender.send(mimeMessage);
            } catch (MessagingException e) {
                logger.error("Unable to process and/or send email.", e);
            }
        }
    }
}
