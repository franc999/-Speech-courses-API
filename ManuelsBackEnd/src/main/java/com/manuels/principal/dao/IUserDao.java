package com.manuels.principal.dao;

import java.util.Optional;
import com.manuels.principal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Long>{
    Optional<User> findByUserName(String username);
}