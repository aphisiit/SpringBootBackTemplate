package com.training.backend.repository;

import com.training.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaSpecificationExecutor<User>,JpaRepository<User,Long> {

    List<User> findByAge(@Param("age") Integer age);

    List<User> findByFirstNameContaining(@Param("firstName") String firstName);

    List<User> findByFirstNameIgnoreCaseContaining(@Param("firstName") String firstName);

    List<User> findByFirstName(@Param("firstName") String firstName);

    List<User> findByLastName(@Param("firstName") String firstName);

}
