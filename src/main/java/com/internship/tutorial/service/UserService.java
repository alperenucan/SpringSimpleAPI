package com.internship.tutorial.service;

import com.internship.tutorial.model.User;

import java.util.List;

public interface UserService {

        User getUserbyID(Long id);

        List<User> getUsers();

        User createUser(User user);

        User updateUser(Long id, User user);

        void deleteUser(Long id);

}
