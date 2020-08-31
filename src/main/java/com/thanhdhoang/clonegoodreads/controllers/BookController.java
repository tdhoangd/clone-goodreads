package com.thanhdhoang.clonegoodreads.controllers;

import com.thanhdhoang.clonegoodreads.persistence.domain.Author;
import com.thanhdhoang.clonegoodreads.persistence.domain.Book;
import com.thanhdhoang.clonegoodreads.services.springdatajpa.BookSDJService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/book")
@Slf4j
@Controller
public class BookController {

    public static final String CREATE_OR_EDIT_FORM = "book/createOrEditBook";
    private static final String FIND_FORM = "book/findBook";
    private final BookSDJService bookService;

    public BookController(BookSDJService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping({"", "/"})
    public String index(Model model) {
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
        return CREATE_OR_EDIT_FORM;
    }

    @PostMapping({"/new"})
    public String processNewBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return CREATE_OR_EDIT_FORM;
        } else {
            Book savedBook = bookService.save(book);
            return "redirect:/book/" + savedBook.getId() + "/show";
        }
    }

    @GetMapping({"{id}/edit"})
    public String initEditBook(@PathVariable Long id, Model model) {
        model.addAttribute(bookService.findById(id));
        return CREATE_OR_EDIT_FORM;
    }

    @PostMapping({"{id}/edit"})
    public String processEditBook(@Valid Book book, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return CREATE_OR_EDIT_FORM;
        } else {
            book.setId(id);
            Book savedBook = bookService.save(book);
            return "redirect:/book/" + savedBook.getId() + "/show";
        }
    }

    @GetMapping({"/find"})
    public String processFindForm(@RequestParam(name ="search-query") String q, Model model) {
        if (q == null || q.length() == 0) {
            return FIND_FORM;
        }

        Set<Book> books = bookService.findByKeyword("%" + q + "%");

        System.out.println(books.size());

        if (books.isEmpty()) {
            model.addAttribute("notFoundError", "found nothing");
            return FIND_FORM;
        } else if (books.size() == 1) {
            Book book = books.stream().collect(Collectors.toList()).get(0);
            model.addAttribute("book", book);
            return "redirect:/book/" + book.getId() + "/show";
        } else {
            // multiple books
            // TODO: add pagination
            model.addAttribute("books", books);
            return FIND_FORM;
        }
    }
}
