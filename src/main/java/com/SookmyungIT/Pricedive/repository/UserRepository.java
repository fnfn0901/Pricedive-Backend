package com.SookmyungIT.Pricedive.repository;

import com.SookmyungIT.Pricedive.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}