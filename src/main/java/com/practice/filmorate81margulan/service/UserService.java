package com.practice.filmorate81margulan.service;

import com.practice.filmorate81margulan.exception.NotFoundException;
import com.practice.filmorate81margulan.exception.ValidationException;
import com.practice.filmorate81margulan.model.User;
import com.practice.filmorate81margulan.storage.UserStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserStorage userStorage;


    public List<User> getUsers(){
        return userStorage.findAll();
    }

    public User createUser(User user){
        //электронная почта не может быть пустой и должна содержать символ @;
        if(user.getEmail()==null || !user.getEmail().contains("@")){
            throw new ValidationException("не правильный формат почты");
        }
        //логин не может быть пустым и содержать пробелы;
        if (user.getLogin()==null || user.getLogin().isEmpty()){
            throw new ValidationException("логин не может быть пустым и содержать пробелы");
        }
        //    имя для отображения может быть пустым
        //    — в таком случае будет использован логин;
        if (user.getName()==null){
            user.setName(user.getLogin());
        }

        //дата рождения не может быть в будущем.
        if (user.getBirthday().isAfter(LocalDate.now())){
            throw new ValidationException("дата рождения не может быть в будущем");
        }

        return userStorage.create(user);
    }


    public User updateUser(User user){
        if(user.getEmail()==null || !user.getEmail().contains("@")){
            throw new ValidationException("не правильный формат почты");
        }
        //логин не может быть пустым и содержать пробелы;
        if (user.getLogin()==null || user.getLogin().isEmpty()){
            throw new ValidationException("логин не может быть пустым и содержать пробелы");
        }
        //    имя для отображения может быть пустым
        //    — в таком случае будет использован логин;
        if (user.getName()==null){
            user.setName(user.getLogin());
        }

        //дата рождения не может быть в будущем.
        if (user.getBirthday().isAfter(LocalDate.now())){
            throw new ValidationException("дата рождения не может быть в будущем");
        }

        User existingUser = userStorage.findById(user.getId());
        if(existingUser==null){
            throw new NotFoundException("пользователь не найден");
        }


        return userStorage.update(user);
    }

    public void addFriend(int userId, int friendId){

    }
}
