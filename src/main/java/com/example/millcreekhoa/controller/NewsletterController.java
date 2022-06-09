package com.example.millcreekhoa.controller;

import com.example.millcreekhoa.data.DocumentDto;
import com.example.millcreekhoa.entity.DocumentEntity;
import com.example.millcreekhoa.entity.NewsletterEntity;
import com.example.millcreekhoa.service.DocumentService;
import com.example.millcreekhoa.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
