package com.voidtracker.oms.user.service;

import com.voidtracker.oms.commons.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final Map<String, UserDto> users = new HashMap<>();

    public UserDto createUser(UserDto userDto) {
        users.put(userDto.getId(), userDto);
        return userDto;
    }

    public Optional<UserDto> getUser(String id) {
        return Optional.ofNullable(users.get(id));
    }

    public List<UserDto> listUsers() {
        return new ArrayList<>(users.values());
    }

    public Optional<UserDto> updateUser(String id, UserDto userDto) {
        if (!users.containsKey(id)) return Optional.empty();
        users.put(id, userDto);
        return Optional.of(userDto);
    }

    public boolean deleteUser(String id) {
        return users.remove(id) != null;
    }
}
