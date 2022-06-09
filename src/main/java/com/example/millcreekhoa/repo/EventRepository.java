package com.example.millcreekhoa.repo;

import com.example.millcreekhoa.entity.DocumentEntity;
import com.example.millcreekhoa.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Integer> {
    List<EventEntity> findAllByOrderByDateAsc();
    EventEntity findAllById(Integer id);

}
