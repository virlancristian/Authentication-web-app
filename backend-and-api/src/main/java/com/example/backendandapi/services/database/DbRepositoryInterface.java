package com.example.backendandapi.services.database;

import com.example.backendandapi.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbRepositoryInterface extends JpaRepository<User, Integer> {

}
