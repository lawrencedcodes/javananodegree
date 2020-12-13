package com.example.mvc_basics.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

import com.example.mvc_basics.mapper.UsersMapper;
import com.example.mvc_basics.model.User;

@Service
public class UserService {

    private final UsersMapper usersMapper;
    private final HashService hashService;

    public UserService(UsersMapper userMapper, HashService hashService) {
        this.usersMapper = userMapper;
        this.hashService = hashService;
    }

    public boolean isUsernameAvailable(String username) {
        return usersMapper.getUser(username) == null;
    }

    public int createUser(User user) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        return usersMapper.addUser(new User(null, user.getUsername(), encodedSalt, hashedPassword, user.getFirstName(),
                user.getLastName()));
    }

    public User getUser(String username) {
        return usersMapper.getUser(username);
    }
}
