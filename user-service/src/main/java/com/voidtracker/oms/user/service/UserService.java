package com.voidtracker.oms.user.service;

import com.voidtracker.oms.user.dto.UserProfileDto;
import com.voidtracker.oms.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserProfileDto> listUsers() {
        return userRepository.findAll();
    }

    public UserProfileDto getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserProfileDto createUser(UserProfileDto user) {
        return userRepository.save(user);
    }

    public UserProfileDto updateUser(String id, UserProfileDto user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
