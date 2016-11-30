package com.tsystems.mms.pf23.sb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * @author Marco Grunert (marco.grunert@t-systems.com)
 */
@Controller
public class RegisterController extends WebMvcConfigurerAdapter {
    @Autowired
    SubscriberRepository repository;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/subscribed").setViewName("subscribed");
    }

    @GetMapping("/")
    public String showForm(Subscriber subscriber) {
        return "register";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid Subscriber subscriber, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        if (null != repository.findByEmail(subscriber.getEmail())) {
            bindingResult.addError(new FieldError("subscriber", "email", "email [" + subscriber.getEmail() + "] already registered"));
            return "register";
        }

        repository.saveAndFlush(subscriber);

        return "redirect:/subscribed";
    }
}
