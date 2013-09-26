package com.goeswhere.ivy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class Main {

    final List<String> items = new ArrayList<String>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "home.html";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    String save(@RequestParam("val") String val) {
        items.add(val);
        return "redirect:/" + (items.size() - 1);
    }

    @RequestMapping(value = "/{id:\\d+}")
    @ResponseBody
    String fetch(@PathVariable("id") int id) {
        return items.get(id);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }
}
