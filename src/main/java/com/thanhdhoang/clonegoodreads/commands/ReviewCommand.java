package com.thanhdhoang.clonegoodreads.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class ReviewCommand {
    private Long id;
    private String text;

    @NotNull
    private Date reviewDate;

    @Min(1)
    @Max(5)
    private Integer rating;

    @NotNull
    private UserCommand user;

    @NotNull
    private BookCommand book;
}
