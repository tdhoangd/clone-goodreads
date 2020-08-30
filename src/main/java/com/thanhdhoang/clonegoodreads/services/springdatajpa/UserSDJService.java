package com.thanhdhoang.clonegoodreads.services.springdatajpa;

import com.thanhdhoang.clonegoodreads.exception.NotFoundException;
import com.thanhdhoang.clonegoodreads.persistence.domain.Author;
import com.thanhdhoang.clonegoodreads.persistence.domain.User;
import com.thanhdhoang.clonegoodreads.persistence.repositories.UserRepository;
import com.thanhdhoang.clonegoodreads.services.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserSDJService implements UserService {

    private final UserRepository userRepository;

    public UserSDJService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User findById(Long aLong) {
        Optional<User> optionalUser = userRepository.findById(aLong);
        if (optionalUser.isEmpty())
            throw new NotFoundException("User by id " + aLong + " not found");
        return optionalUser.get();
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }
}
