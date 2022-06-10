package com.example.millcreekhoa.repo;

import com.example.millcreekhoa.entity.BoardMemberEntity;
import com.example.millcreekhoa.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMemberRepository extends JpaRepository<BoardMemberEntity, Integer> {
    List<BoardMemberEntity> findAllByOrderByIdAsc();
    BoardMemberEntity findAllById(Integer id);
}
