package com.thanhdhoang.clonegoodreads.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageModel {

    private final int BUTTONS_TO_SHOW = 3;
    private int startPage;
    private int endPage;

    public PageModel(int totalPages, int currentPage) {

        int halfPagesToShow = BUTTONS_TO_SHOW / 2;

        if (totalPages <= BUTTONS_TO_SHOW) {
            setStartPage(1);
            setEndPage(totalPages);

        } else if (currentPage - halfPagesToShow <= 0) {
            setStartPage(1);
            setEndPage(BUTTONS_TO_SHOW);

        } else if (currentPage + halfPagesToShow == totalPages) {
            setStartPage(currentPage - halfPagesToShow);
            setEndPage(totalPages);

        } else if (currentPage + halfPagesToShow > totalPages) {
            setStartPage(totalPages - BUTTONS_TO_SHOW + 1);
            setEndPage(totalPages);

        } else {
            setStartPage(currentPage - halfPagesToShow);
            setEndPage(currentPage + halfPagesToShow);
        }
    }
}
