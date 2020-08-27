package com.thanhdhoang.clonegoodreads.controllers;

import com.thanhdhoang.clonegoodreads.persistence.domain.Book;
import com.thanhdhoang.clonegoodreads.services.springdatajpa.BookSDJService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/book")
@Slf4j
@Controller
public class BookController {

    private final BookSDJService bookService;

    public BookController(BookSDJService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping({"", "/"})
    public String getIndex() {
        return "book/index";
    }

    @GetMapping("/show/{id}")
    public String showBook(@PathVariable Long id, Model model) {
        log.debug("Getting book with id: " + id);

        Book book = bookService.findById(id);

        model.addAttribute("book", book);

        return "book/showBook";
    }
}
