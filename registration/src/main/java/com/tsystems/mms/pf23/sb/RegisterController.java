package com.tsystems.mms.pf23.sb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Marco Grunert (marco.grunert@t-systems.com)
 */
@Controller
public class RegisterController {
    @RequestMapping("register")
    public String register(@RequestParam(value = "email", required = true) String email, Model model) {
        model.addAttribute("email", email);
        return "register";
    }
}
