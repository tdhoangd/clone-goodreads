package com.thanhdhoang.clonegoodreads.persistence.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Review extends BaseEntity {

    private String text;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reviewDate;

    @Column(nullable = false )
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
