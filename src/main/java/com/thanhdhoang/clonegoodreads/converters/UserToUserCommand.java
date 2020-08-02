package com.thanhdhoang.clonegoodreads.converters;

import com.thanhdhoang.clonegoodreads.commands.UserCommand;
import com.thanhdhoang.clonegoodreads.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserCommand implements Converter<User, UserCommand> {

    @Override
    public UserCommand convert(User source) {
        if (source == null) {
            return null;
        }

        final UserCommand userCommand = new UserCommand();

        userCommand.setId(source.getId());
        userCommand.setUsername(source.getUsername());
        userCommand.setSessionToken(source.getSessionToken());
        userCommand.setPassword(source.getPassword());
        userCommand.setFirstName(source.getFirstName());
        userCommand.setLastName(source.getLastName());
        userCommand.setEmail(source.getEmail());

        return userCommand;
    }
}
