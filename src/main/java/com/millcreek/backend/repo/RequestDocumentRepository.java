package com.millcreek.backend.repo;

import com.millcreek.backend.entity.RequestDocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestDocumentRepository extends JpaRepository<RequestDocumentEntity, Integer> {

    @Query(value = "select id,name,category,friendly_name,name,description,'' as editable_columns, '' as item from request", nativeQuery = true)
    List<RequestDocumentEntity> findAll();

    RequestDocumentEntity findAllById(Integer id);

    List<RequestDocumentEntity> findByNameAndAndDescription(String name, String description);

    @Override
    void deleteById(Integer integer);
}
