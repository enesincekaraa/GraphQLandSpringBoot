package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Model.UserRequest;
import com.example.demo.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return  userRepository.findAll();
    }

    public User getOneUser(Long id) {
       return userRepository.findById(id).orElseThrow(()->new RuntimeException("user not found"));
    }

    public User createUser(UserRequest userRequest) {
      User user= User.builder()
              .userName(userRequest.getUserName())
              .mail(userRequest.getMail())
              .role(userRequest.getRole())
              .build();
      return userRepository.save(user);
    }

    public User updateUser(UserRequest userRequest) {
        User existing=getOneUser(userRequest.getId());
        existing.setRole(userRequest.getRole());
        existing.setUserName(userRequest.getUserName());
        existing.setMail(userRequest.getMail());
        return userRepository.save(existing);

    }

    public void deleteUser(Long id) {
        User existing=getOneUser(id);
        userRepository.delete(existing);
    }
}
