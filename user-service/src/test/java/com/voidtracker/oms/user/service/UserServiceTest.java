package com.voidtracker.oms.user.service;

import com.voidtracker.oms.commons.dto.UserDto;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {
    @Test
    void createAndGetUser() {
        UserService service = new UserService();
        UserDto user = new UserDto("id1", "user1", "ADMIN", "hash", Instant.now(), true);
        service.createUser(user);
        assertThat(service.getUser("id1")).isPresent();
    }
}
