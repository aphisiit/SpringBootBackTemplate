package com.training.backend.service;

import com.training.backend.domain.User;
import com.training.backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllUser() {
        LOGGER.info("find all users");
        return userRepository.findAll();
    }

    @Override
    public List<User> findByFirstNameIgnoreCaseContaining(String firstName) {
        LOGGER.info("findByFirstNameIgnoreCaseContaining (firstName) : {}",firstName);
        return userRepository.findByFirstNameIgnoreCaseContaining(firstName);
    }

    @Override
    public List<User> findByFirstNameContaining(String firstName) {
        return userRepository.findByFirstNameContaining(firstName);
    }

    @Override
    public List<User> findByFisrtName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    @Override
    public List<User> findByAge(Integer age) {
        return userRepository.findByAge(age);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
