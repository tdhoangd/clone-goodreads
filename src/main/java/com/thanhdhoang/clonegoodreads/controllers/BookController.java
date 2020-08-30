package com.thanhdhoang.clonegoodreads.controllers;

import com.thanhdhoang.clonegoodreads.persistence.domain.Author;
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
import java.util.List;

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
        model.addAttribute("book", Book.builder().build());
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
    public String processFindForm(Book book, BindingResult result, Model model) {
        return "";
//        if (book.getTitle() == null || author.getName().length() == 0) {
//            return FIND_FORM;
//        }
//
//        List<Book> books = bookService.findAllByNameLikeIgnoreCase("%" + author.getName() +
//                "%");
//
//        System.out.println("RET SIZE" + authors.size());
//
//        if (authors.isEmpty()) {
//            result.rejectValue("name", "notFound", "not found");
//            return FIND_FORM;
//        } else if (authors.size() == 1) {
//            author = authors.get(0);
//            return "redirect:/author/" + author.getId() + "/show";
//        } else {
//            // multiple authors
//            model.addAttribute("authors", authors);
//            return FIND_FORM;
//        }
    }
}
