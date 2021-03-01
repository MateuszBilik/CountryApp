package com.asap.country_app.database.repository;

import com.asap.country_app.database.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<AppUser, UUID> {

    //TODO decide if leave as is or maybe better to insert in the database with lowercase
    @Query(value = "select u from AppUser u where lower(email) = lower(:email)")
    Optional<AppUser> findByEmail(String email);

}
