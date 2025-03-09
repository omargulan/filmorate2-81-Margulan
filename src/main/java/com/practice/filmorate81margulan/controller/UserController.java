package com.practice.filmorate81margulan.controller;

import com.practice.filmorate81margulan.model.Film;
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

    //добавление в друзья
    @PutMapping("/{userId}/friends/{friendId}")
    public void addfriend(@PathVariable int userId, @PathVariable int friendId){
        userService.addFriend(userId, friendId);
    }
    //удаление из друзей.
    @DeleteMapping("/users/{id}/friends/{friendId}")
    public void deletfriend(@PathVariable int userId, @PathVariable int friendId){
        userService.deleteFriend(userId, friendId);
    }
    //возвращаем список пользователей, являющихся его друзьями.
    @GetMapping("/users/{id}/friends")
    public Collection<Integer> getFriends(@PathVariable int id){

    }
    //список друзей, общих с другим пользователем.
    @GetMapping("/users/{id}/friends/common/{otherId}")
    public Collection<Integer> getFriends(@PathVariable int id, @PathVariable int otherId){
        return userService.getFriends(id, otherId);
    }

    //пользователь ставит лайк фильму.
    @PutMapping("/films/{id}/like/{userId}")
    public void like(@PathVariable int id, @PathVariable int userId){

    }

    //пользователь удаляет лайк
    @DeleteMapping("/films/{id}/like/{userId}")
    public void unlike(@PathVariable int id, @PathVariable int userId){

    }

    //возвращает список из первых count фильмов по количеству лайков.
    // Если значение параметра count не задано, верните первые 10.
    @GetMapping("/films/popular?count={count}")
    public List<Film> getPopularFilms(@PathVariable int count){

    }



}
