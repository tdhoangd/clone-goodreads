package com.thanhdhoang.clonegoodreads.converters;

import com.thanhdhoang.clonegoodreads.commands.ReviewCommand;
import com.thanhdhoang.clonegoodreads.persistence.model.Review;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReviewCommandToReview implements Converter<ReviewCommand, Review> {

    private final UserCommandToUser userConverter;

    public ReviewCommandToReview(UserCommandToUser userConverter) {
        this.userConverter = userConverter;
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

        return review;
    }
}
