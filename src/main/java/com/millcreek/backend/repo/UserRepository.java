package com.millcreek.backend.repo;

import com.millcreek.backend.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity getUserEntityByUsername (final String username);
}
