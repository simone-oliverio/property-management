package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

   // Optional<UserEntity> findByOwnerEmailAndPassword(String email, String password);

    @Query("SELECT u FROM UserEntity u WHERE u.ownerEmail = :email AND u.password = :password")
    Optional<UserEntity> findByOwnerEmailAndPassword(@Param("email") String email, @Param("password") String password);

    //@Query("SELECT u FROM UserEntity u WHERE u.ownerEmail = :email)
    Optional<UserEntity> findByOwnerEmail(@Param("email") String email);


}
