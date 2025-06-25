package com.voidtracker.oms.user.service;

import com.voidtracker.oms.user.dto.UserProfileDto;
import com.voidtracker.oms.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {
    static class InMemoryUserRepository implements UserRepository {
        private final Map<String, UserProfileDto> users = new HashMap<>();
        @Override
        public java.util.List<UserProfileDto> findAll() { return new java.util.ArrayList<>(users.values()); }
        @Override
        public Optional<UserProfileDto> findById(String id) { return Optional.ofNullable(users.get(id)); }
        @Override
        public UserProfileDto save(UserProfileDto user) { users.put(user.id(), user); return user; }
        @Override
        public void deleteById(String id) { users.remove(id); }
    }

    @Test
    void createAndGetUser() {
        UserRepository repo = new InMemoryUserRepository();
        UserService service = new UserService(repo);
        UserProfileDto user = new UserProfileDto("id1", "user1", "User One", true);
        service.createUser(user);
        UserProfileDto found = service.getUser("id1");
        assertThat(found).isNotNull();
        assertThat(found.id()).isEqualTo("id1");
        assertThat(found.username()).isEqualTo("user1");
    }
}
