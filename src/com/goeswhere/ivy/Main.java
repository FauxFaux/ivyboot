package com.goeswhere;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.boot.context.embedded.*;
import org.springframework.boot.context.embedded.jetty.*;

@Controller
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class Main {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }
}
