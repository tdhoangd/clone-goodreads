package com.thanhdhoang.clonegoodreads.converters;

import com.thanhdhoang.clonegoodreads.commands.ReviewCommand;
import com.thanhdhoang.clonegoodreads.domain.Review;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReviewToReviewCommand implements Converter<Review, ReviewCommand> {

    private final UserToUserCommand userConverter;
    private final BookToBookCommand bookConverter;

    public ReviewToReviewCommand(UserToUserCommand userConverter,
                                 BookToBookCommand bookConverter) {
        this.userConverter = userConverter;
        this.bookConverter = bookConverter;
    }

    @Override
    public ReviewCommand convert(Review source) {
        if (source == null) {
            return null;
        }

        final ReviewCommand reviewCommand = new ReviewCommand();

        reviewCommand.setId(source.getId());
        reviewCommand.setText(source.getText());
        reviewCommand.setReviewDate(source.getReviewDate());
        reviewCommand.setRating(source.getRating());
        reviewCommand.setUser(userConverter.convert(source.getUser()));
        reviewCommand.setBook(bookConverter.convert(source.getBook()));

        return reviewCommand;
    }
}
