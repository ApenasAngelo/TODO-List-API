package com.apenasnagelo.api_rest.Repository;

import com.apenasnagelo.api_rest.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}