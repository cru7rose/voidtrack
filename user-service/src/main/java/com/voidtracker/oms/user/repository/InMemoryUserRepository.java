package com.voidtracker.oms.user.repository;

import com.voidtracker.oms.user.dto.UserProfileDto;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final Map<String, UserProfileDto> users = new HashMap<>();

    @Override
    public List<UserProfileDto> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public Optional<UserProfileDto> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public UserProfileDto save(UserProfileDto user) {
        users.put(user.id(), user);
        return user;
    }

    @Override
    public void deleteById(String id) {
        users.remove(id);
    }
}
