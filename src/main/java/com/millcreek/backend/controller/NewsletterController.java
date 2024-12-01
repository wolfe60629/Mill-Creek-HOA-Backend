package com.millcreek.backend.controller;

import com.millcreek.backend.entity.NewsletterEntity;
import com.millcreek.backend.service.NewsletterService;
import com.millcreek.backend.data.DocumentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class NewsletterController {

    @Autowired
    NewsletterService newsletterService;

   @PostMapping(value = "/newsletters/new")
    public NewsletterEntity addNewNewsletter(@RequestBody DocumentDto documentDto) {
      return newsletterService.addNewNewsletter(documentDto);
   }

   @GetMapping(value = "/newsletters")
    public List<NewsletterEntity> getAllNewsletters() {
       return newsletterService.getAllNewsletters();
   }

    @GetMapping(value = "/newsletters/{id}")
    NewsletterEntity getNewsletterById(@PathVariable Integer id) {
        return newsletterService.getNewsletterById(id);
    }
}
