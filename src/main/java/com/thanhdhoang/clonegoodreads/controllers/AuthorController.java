package com.thanhdhoang.clonegoodreads.controllers;

import com.thanhdhoang.clonegoodreads.services.springdatajpa.AuthorSDJService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/author")
public class AuthorController {

    private final AuthorSDJService authorService;

    public AuthorController(AuthorSDJService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping({"", "/"})
    public String getIndex() {
        return "author/index";
    }

    @GetMapping("/show/{id}")
    public String viewAuthor(@PathVariable Long id, Model model) {
        log.debug("Getting author with id: " + id);
        model.addAttribute("author", authorService.findById(id));
        return "author/showAuthor";
    }

}
