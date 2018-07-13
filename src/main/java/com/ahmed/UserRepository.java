package com.ahmed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahmed.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
