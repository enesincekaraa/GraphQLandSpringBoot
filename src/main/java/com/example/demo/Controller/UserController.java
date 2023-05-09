package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Model.UserRequest;
import com.example.demo.Service.UserService;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @QueryMapping
    List<User> getAllUsers(){
        return  userService.getAllUsers();

    }

    @QueryMapping
    User getById(@Arguments Long id){
        return  userService.getOneUser (id);

    }

    @MutationMapping
    User createUser(@Arguments UserRequest userRequest){
        return  userService.createUser(userRequest);

    }
    @MutationMapping
    User updateUser(@Arguments UserRequest userRequest){
        return  userService.updateUser(userRequest);

    }
    @MutationMapping
    Boolean delete(@Arguments Long id){
         userService.deleteUser(id);
         return true;

    }
}
