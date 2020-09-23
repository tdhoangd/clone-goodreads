package com.thanhdhoang.clonegoodreads.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class IndexController {

    @GetMapping({"", "/", "/index", "/index.html"})
    public String index() {
        log.debug("Getting index page");
        return "index";
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "403";
    }
}
