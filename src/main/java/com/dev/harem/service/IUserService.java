package com.dev.harem.service;

import com.dev.harem.entity.User;

import java.util.List;

public interface IUserService {
    User createUser(User user);
    User findByUsername(String username);
    List<User> getUsers();
}
