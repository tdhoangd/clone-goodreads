package com.thanhdhoang.clonegoodreads.controllers;

import com.thanhdhoang.clonegoodreads.persistence.domain.Author;
import com.thanhdhoang.clonegoodreads.services.springdatajpa.AuthorSDJService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/author")
public class AuthorController {

    public static final String CREATE_OR_EDIT_FORM = "author/createOrEditAuthor";
    public static final String FIND_FORM = "author/findAuthor";
    private final AuthorSDJService authorService;

    public AuthorController(AuthorSDJService authorService) {
        this.authorService = authorService;
    }


    @RequestMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("author", Author.builder().build());
        return "author/index";
    }

    @GetMapping("/{id}/show")
    public String showAuthor(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorService.findById(id));
        return "author/showAuthor";
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("author", Author.builder().build());
        return CREATE_OR_EDIT_FORM;
    }

    @PostMapping("/new")
    public String processCreationFrom(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return CREATE_OR_EDIT_FORM;
        } else {
            Author savedAuthor = authorService.save(author);
            return "redirect:/author/" + savedAuthor.getId() + "/show";
        }
    }

    @GetMapping("/{id}/edit")
    public String initEditAuthorForm(@PathVariable Long id, Model model) {
        model.addAttribute(authorService.findById(id));
        return CREATE_OR_EDIT_FORM;
    }

    @PostMapping({"/{id}/edit"})
    public String processEditAuthorForm(@Valid Author author, BindingResult result,
                                        @PathVariable Long id) {
        if (result.hasErrors()) {
            return CREATE_OR_EDIT_FORM;
        } else {
            author.setId(id);
            Author savedAuthor = authorService.save(author);
            return "redirect:/author/" + savedAuthor.getId() + "/show";
        }
    }

    @GetMapping({"/find"})
    public String processFindForm(Author author, BindingResult result, Model model) {
        if (author.getName() == null || author.getName().length() == 0) {
            return FIND_FORM;
        }

        Set<Author> authors = authorService.findAllByNameLikeIgnoreCase("%" + author.getName() +
                "%");

        if (authors.isEmpty()) {
            result.rejectValue("name", "notFound", "not found");
            return FIND_FORM;
        } else if (authors.size() == 1) {
            author = authors.stream().collect(Collectors.toList()).get(0);
            return "redirect:/author/" + author.getId() + "/show";
        } else {
            // multiple authors
            model.addAttribute("authors", authors);
            return FIND_FORM;
        }
    }
}
