package com.example.backendandapi.services.userdb;

import com.example.backendandapi.models.dbentities.UserDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserDbRepository extends JpaRepository<UserDbEntity, Long> {
    @Query(value = "SELECT * FROM Users WHERE username = :username", nativeQuery = true)
    UserDbEntity findByUsernameNativeQuery(@RequestParam("username") String username);
}
