package com.apenasnagelo.api_rest.Repository;

import com.apenasnagelo.api_rest.Exceptions.BusinessException;
import com.apenasnagelo.api_rest.Exceptions.RequiredFieldException;
import com.apenasnagelo.api_rest.Model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public void save(User user) {
        if(user.getLogin() == null)
            throw new RequiredFieldException("login");
        if(user.getPassword() == null)
            throw new RequiredFieldException("password");
        if (user.getId() == null)
            System.out.println("SAVE: " + user);
        else
            System.out.println("UPDATE: " + user);
    }

    public void deleteById(Integer id) {
        System.out.println("DELETE: " + id);
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        users.add(new User("admin", "admin"));
        users.add(new User("user", "user"));
        return users;
    }

    public User findById(Integer id) {
        return new User("admin", "admin");
    }

    public User findByUsername(String username) {
        return new User("admin", "admin");
    }
}
