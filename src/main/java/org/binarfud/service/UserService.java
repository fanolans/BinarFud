package org.binarfud.service;

import org.binarfud.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface UserService {
    Page<User> findAll(Pageable pageable);
    Map findById(UUID id);
    Map save(User user);
    Map update(UUID id, User user);
    Map delete(UUID id);
}
