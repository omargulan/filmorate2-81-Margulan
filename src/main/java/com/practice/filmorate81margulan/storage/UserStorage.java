package com.practice.filmorate81margulan.storage;

import com.practice.filmorate81margulan.model.User;

import java.util.List;

public interface UserStorage {
    User create(User user);
    User update (User user);
    List<User> findAll();
    User findById(int id);
}
