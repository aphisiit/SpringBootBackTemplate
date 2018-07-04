package com.training.backend.service;

import com.training.backend.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);
    List<User> findAllUser();
    List<User> findByFirstNameIgnoreCaseContaining(String firstName);
    List<User> findByFirstNameContaining(String firstName);
    List<User> findByFisrtName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findByAge(Integer age);
    void deleteById(Long id);
}
