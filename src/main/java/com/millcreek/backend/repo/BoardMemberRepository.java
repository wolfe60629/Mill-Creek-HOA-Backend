package com.millcreek.backend.repo;

import com.millcreek.backend.entity.BoardMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMemberRepository extends JpaRepository<BoardMemberEntity, Integer> {
    List<BoardMemberEntity> findAllByOrderByIdAsc();
    BoardMemberEntity findAllById(Integer id);
}
