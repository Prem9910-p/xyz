package com.example.xyz.Repository;

import com.example.xyz.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReository extends JpaRepository<User, Integer> {
}
