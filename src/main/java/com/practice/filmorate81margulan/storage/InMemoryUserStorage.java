package com.practice.filmorate81margulan.storage;

import com.practice.filmorate81margulan.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class InMemoryUserStorage implements  UserStorage{
    private final Map<Integer, User> users = new HashMap<>();
    private int count = 1;
    @Override
    public User create(User user) {
        user.setId(count++);
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User update(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User findById(int id) {
        return  users.get(id);
    }
}
