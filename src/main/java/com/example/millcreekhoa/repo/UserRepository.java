package com.example.millcreekhoa.repo;

import com.example.millcreekhoa.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
