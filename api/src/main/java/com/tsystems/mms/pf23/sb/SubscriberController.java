package com.tsystems.mms.pf23.sb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Marco Grunert (marco.grunert@t-systems.com)
 */
@RestController
@CrossOrigin
@RequestMapping("/subscribers")
public class SubscriberController {
    @Autowired
    private SubscriberRepository subscriberRepository;

    @RequestMapping(method = RequestMethod.GET)
    List<Subscriber> getSubscribers() {
        return subscriberRepository.findAll();
    }

    @RequestMapping(path = "{email}", method = RequestMethod.GET)
    Subscriber getSubscriber(@PathVariable(name = "email") String email) {
        return subscriberRepository.findByEmail(email);
    }
}
