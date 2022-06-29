package com.example.millcreekhoa.repo;

import com.example.millcreekhoa.data.CurrentUser;
import com.example.millcreekhoa.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity getUserEntityByUsername (final String username);
}
