package com.thanhdhoang.clonegoodreads.controllers;

import com.thanhdhoang.clonegoodreads.model.PageModel;
import com.thanhdhoang.clonegoodreads.persistence.domain.Review;
import com.thanhdhoang.clonegoodreads.persistence.domain.User;
import com.thanhdhoang.clonegoodreads.services.springdatajpa.ReviewSDJService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/review")
@Controller
public class ReviewController {

    private static final int INIT_PAGE = 0;
    private static final int PAGE_SIZE = 10;
    private final ReviewSDJService reviewService;

    public ReviewController(ReviewSDJService reviewService) {
        this.reviewService = reviewService;
    }

//    @GetMapping({"/{id}"})
//    public String reviewList(@PathVariable Long id,
//                             @RequestParam(name = "page") Optional<Integer> page, Model model) {
//        int evalPage = (page.orElse(0) < 1) ? INIT_PAGE : page.get()-1;
//        Pageable pageable = PageRequest.of(evalPage, PAGE_SIZE);
//
//        Page<Review> reviewlist = reviewService.findByBookId(id, pageable);
//        long numOfReviews = reviewlist.getTotalElements();
//        PageModel pageModel = new PageModel(reviewlist.getTotalPages(), evalPage);
//
//        Map<Review, User> reviewUserMap = reviewlist.getContent().stream().collect(
//                Collectors.toMap(x -> x, x -> x.getUser()));
//
//        model.addAttribute("pageModel", pageModel);
//        model.addAttribute("pageSize", PAGE_SIZE);
//        model.addAttribute("reviewlist", reviewlist);
//        model.addAttribute("bookId", id);
//        model.addAttribute("reviewUserMap", reviewUserMap);
//
//        return "fragments/reviewList";
//    }


    @GetMapping({"/{id}"})
    public String reviewList(@PathVariable Long id,
                             @RequestParam(name = "page") Optional<Integer> page, Model model) {
        int evalPage = (page.orElse(0) < 1) ? INIT_PAGE : page.get()-1;
        Pageable pageable = PageRequest.of(evalPage, PAGE_SIZE);

        Page<Review> reviewlist = reviewService.findByBookId(id, pageable);
        long numOfReviews = reviewlist.getTotalElements();
        PageModel pageModel = new PageModel(reviewlist.getTotalPages(), evalPage);

//        Map<Review, User> reviewUserMap = reviewlist.getContent().stream().collect(
//                Collectors.toMap(x -> x, x -> x.getUser()));

        model.addAttribute("pageModel", pageModel);
        model.addAttribute("pageSize", PAGE_SIZE);
        model.addAttribute("reviewlist", reviewlist);
        model.addAttribute("bookId", id);
//        model.addAttribute("reviewUserMap", reviewUserMap);
        model.addAttribute("reviews", reviewlist.getContent());

        return "fragments/reviewList";
    }
}


