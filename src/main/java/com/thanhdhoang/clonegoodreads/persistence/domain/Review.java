package com.thanhdhoang.clonegoodreads.persistence.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Review extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String reviewText;

    @NotNull
    @Column(columnDefinition = "TINYINT UNSIGNED ")
    private Short ratingValue;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date timestamp;


    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "book_id")
    private Book book;
}
