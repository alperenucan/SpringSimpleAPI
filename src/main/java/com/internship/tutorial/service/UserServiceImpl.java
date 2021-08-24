package com.internship.tutorial.service;

import com.internship.tutorial.model.User;
import com.internship.tutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public User getUserbyID(Long id) {
        final User user = userRepository.findById(id).get();
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> userList=userRepository.findAll();
        return userList;
    }

    @Override
    public User createUser(User user) {
        userRepository.save(new User(user.getId(),user.getUsername(),user.getPassword(),user.getEmail(),user.getAge()));
        return user;
    }

    @Override
    public User updateUser(Long id, User user) {
        User updatedUser=userRepository.findById(id).get();
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setEmail(user.getEmail());
        userRepository.save(updatedUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long id) {
        User user =userRepository.findById(id).get();
        userRepository.delete(user);
    }
}
