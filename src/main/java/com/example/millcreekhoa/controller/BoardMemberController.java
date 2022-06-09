package com.example.millcreekhoa.controller;

import com.example.millcreekhoa.data.DocumentDto;
import com.example.millcreekhoa.entity.DocumentEntity;
import com.example.millcreekhoa.service.DocumentService;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class DocumentsController {

    @Autowired
    DocumentService documentService;

   @PostMapping(value = "/documents/new")
    public DocumentEntity addNewDownload(@RequestBody DocumentDto documentDto) {
      return documentService.addNewDocument(documentDto);
   }

   @GetMapping(value = "/documents")
    public List<DocumentEntity> getAllDownloads() {
       return documentService.getAllDocuments();
   }
}
