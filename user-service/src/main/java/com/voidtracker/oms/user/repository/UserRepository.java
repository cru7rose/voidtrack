package com.voidtracker.oms.user.repository;

import com.voidtracker.oms.user.dto.UserProfileDto;
import java.util.*;

public interface UserRepository {
    List<UserProfileDto> findAll();
    Optional<UserProfileDto> findById(String id);
    UserProfileDto save(UserProfileDto user);
    void deleteById(String id);
}
