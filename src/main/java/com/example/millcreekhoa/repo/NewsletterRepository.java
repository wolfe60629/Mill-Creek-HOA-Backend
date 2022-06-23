package com.example.millcreekhoa.repo;

import com.example.millcreekhoa.entity.DocumentEntity;
import com.example.millcreekhoa.entity.NewsletterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsletterRepository extends JpaRepository<NewsletterEntity, Integer> {
    @Query(value = "select id,crt_ts,category,friendly_name,name,description,'' as item from newsletter order by crt_ts desc ", nativeQuery = true)
    List<NewsletterEntity> findAllByOrderByCreateTimestampDesc();



    NewsletterEntity findAllById(Integer id);

    List<NewsletterEntity> findByNameAndAndDescription(String name, String description);
}
