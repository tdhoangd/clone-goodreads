package com.thanhdhoang.clonegoodreads.converters;

import com.thanhdhoang.clonegoodreads.commands.ReviewCommand;
import com.thanhdhoang.clonegoodreads.domain.Review;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReviewCommandToReview implements Converter<ReviewCommand, Review> {

    private final UserCommandToUser userConverter;
    private final BookCommandToBook bookConverter;

    public ReviewCommandToReview(UserCommandToUser userConverter,
                                 BookCommandToBook bookConverter) {
        this.userConverter = userConverter;
        this.bookConverter = bookConverter;
    }

    @Override
    public Review convert(ReviewCommand source) {
        if (source == null) {
            return null;
        }

        final Review review = new Review();

        review.setId(source.getId());
        review.setText(source.getText());
        review.setReviewDate(source.getReviewDate());
        review.setRating(source.getRating());
        review.setUser(userConverter.convert(source.getUser()));
        review.setBook(bookConverter.convert(source.getBook()));

        return review;
    }
}
