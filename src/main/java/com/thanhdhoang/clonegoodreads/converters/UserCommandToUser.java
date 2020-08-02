package com.thanhdhoang.clonegoodreads.converters;

import com.thanhdhoang.clonegoodreads.commands.UserCommand;
import com.thanhdhoang.clonegoodreads.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserCommandToUser implements Converter<UserCommand, User> {

    @Override
    public User convert(UserCommand source) {
        if (source == null) {
            return null;
        }

        final User user = new User();

        user.setId(source.getId());
        user.setUsername(source.getUsername());
        user.setSessionToken(source.getSessionToken());
        user.setPassword(source.getPassword());
        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());
        user.setEmail(source.getEmail());

        return user;
    }
}
