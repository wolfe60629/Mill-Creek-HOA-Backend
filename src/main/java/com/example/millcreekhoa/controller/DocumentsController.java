package com.example.millcreekhoa.controller;

import com.example.millcreekhoa.data.DocumentDto;
import com.example.millcreekhoa.entity.DocumentEntity;
import com.example.millcreekhoa.service.DocumentService;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

   @GetMapping(value = "/documents/{id}")
   DocumentEntity getDocumentById(@PathVariable Integer id) {
       return documentService.getDocumentById(id);
   }

    @PostMapping(value = "/documents/delete")
    public void deleteRequest(@RequestBody DocumentDto documentDto) {
        documentService.deleteDocument(documentDto);
    }
}
