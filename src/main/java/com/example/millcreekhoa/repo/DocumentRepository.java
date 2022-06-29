package com.example.millcreekhoa.repo;

import com.example.millcreekhoa.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, Integer> {

    @Query(value = "select id,category,friendly_name,name,description,'' as item from document order by  category desc, description asc", nativeQuery = true)
    List<DocumentEntity> findAll();

    DocumentEntity findAllById(Integer id);

    List<DocumentEntity> findByNameAndAndDescription(String name, String description);
}
