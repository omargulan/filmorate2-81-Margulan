package com.practice.filmorate81margulan.controller;

import com.practice.filmorate81margulan.model.User;
import com.practice.filmorate81margulan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @GetMapping
    public Collection<User> getUsers() {
        return userService.getUsers();
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
 //   @PutMapping("/{userId}/friends/{friendId}")
//    public void addfriend(@PathVariable int userId, @PathVariable int friendId){
//        userService.addFriend(userId, friendId);
//    }
//    @DeleteMapping("/{userId}/friends/{friendId}")
//    public void addfriend(@PathVariable int userId, @PathVariable int friendId){
//        userService.deleteFriend(userId, friendId);
//    }
}
