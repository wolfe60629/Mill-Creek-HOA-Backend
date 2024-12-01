package com.millcreek.backend.service;

import com.millcreek.backend.entity.NewsletterEntity;
import com.millcreek.backend.repo.NewsletterRepository;
import com.millcreek.backend.data.DocumentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsletterService {

    @Autowired
    NewsletterRepository newsletterRepository;

    public List<NewsletterEntity> getAllNewsletters() {
        // Grab all documents minus the actual item due to space and time
        return newsletterRepository.findAllByOrderByCreateTimestampDesc().stream().map((document) -> {
            document.setItem("");
            return document;
        }).collect(Collectors.toList());
    }

    public NewsletterEntity getNewsletterById(int id) {
        return newsletterRepository.findAllById(id);
    }

    public NewsletterEntity addNewNewsletter(DocumentDto documentDto) {
            NewsletterEntity entity = new NewsletterEntity(documentDto.getName(),documentDto.getFriendlyName(),documentDto.getDescription(),documentDto.getCategory(), documentDto.getItem());
            return newsletterRepository.save(entity);
        }
    }

