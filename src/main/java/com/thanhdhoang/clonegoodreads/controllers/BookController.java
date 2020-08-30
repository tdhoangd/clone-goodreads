package com.thanhdhoang.clonegoodreads.controllers;

import com.thanhdhoang.clonegoodreads.persistence.domain.Book;
import com.thanhdhoang.clonegoodreads.services.springdatajpa.BookSDJService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/book")
@Slf4j
@Controller
public class BookController {

    public static final String BOOK_CREATE_OR_EDIT_FORM = "book/createOrEditBook";
    private final BookSDJService bookService;

    public BookController(BookSDJService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping({"", "/"})
    public String getIndex() {
        return "book/index";
    }

    @GetMapping("/{id}/show")
    public String showBook(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book/showBook";
    }

    @GetMapping({"/new"})
    public String initNewBook(Model model) {
        model.addAttribute("book", Book.builder().build());
        return BOOK_CREATE_OR_EDIT_FORM;
    }

    @PostMapping({"/new"})
    public String processNewBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return BOOK_CREATE_OR_EDIT_FORM;
        } else {
            Book savedBook = bookService.save(book);
            return "redirect:/book/" + savedBook.getId() + "/show";
        }
    }

    @GetMapping({"{id}/edit"})
    public String initEditBook(@PathVariable Long id, Model model) {
        model.addAttribute(bookService.findById(id));
        return BOOK_CREATE_OR_EDIT_FORM;
    }

    @PostMapping({"{id}/edit"})
    public String processEditBook(@Valid Book book, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return BOOK_CREATE_OR_EDIT_FORM;
        } else {
            book.setId(id);
            Book savedBook = bookService.save(book);
            return "redirect:/book/" + savedBook.getId() + "/show";
        }
    }
}
