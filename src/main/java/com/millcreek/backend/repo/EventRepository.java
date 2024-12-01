package com.millcreek.backend.repo;

import com.millcreek.backend.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Integer> {
    List<EventEntity> findAllByOrderByStartDateAsc();
    EventEntity findAllById(Integer id);

}
