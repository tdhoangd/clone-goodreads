package com.thanhdhoang.clonegoodreads.controllers;

import com.thanhdhoang.clonegoodreads.services.springdatajpa.GenreSDJService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/genres")
@Slf4j
@Controller
public class GenreController {

    private final GenreSDJService genreService;

    public GenreController(GenreSDJService genreService) {
        this.genreService = genreService;
    }

    @RequestMapping({"", "/"})
    public String getGenres(Model model) {
        log.debug("Getting genre list");
        model.addAttribute("genres", genreService.findAll());
        return "genre/index";
    }

    @RequestMapping("/{name}")
    public String getGenre(@PathVariable String name, Model model) {
        log.debug("Getting genre" + name);
        model.addAttribute("genre", genreService.findByName(name));
        return "genre/showGenre";
    }

}
