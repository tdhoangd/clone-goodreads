package com.thanhdhoang.clonegoodreads.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @GetMapping(value = "/error")
    public String error() {
        return "notfound";
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
