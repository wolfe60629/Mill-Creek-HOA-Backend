package com.example.millcreekhoa.repo;

import com.example.millcreekhoa.entity.DocumentEntity;
import com.example.millcreekhoa.entity.NewsletterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsletterRepository extends JpaRepository<NewsletterEntity, Integer> {
    List<NewsletterEntity> findAll();

    NewsletterEntity findAllById(Integer id);

    List<NewsletterEntity> findByNameAndAndDescription(String name, String description);
}
