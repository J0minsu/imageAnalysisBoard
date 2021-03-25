package io.lunit.exam.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping("/api/home")
    public String getHome() {

        logger.info("Success Login & Call APIs");

        return "Hello, World";
    }
}
