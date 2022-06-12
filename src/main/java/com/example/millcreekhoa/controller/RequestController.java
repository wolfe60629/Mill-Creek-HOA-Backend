package com.example.millcreekhoa.controller;

import com.example.millcreekhoa.data.DocumentDto;
import com.example.millcreekhoa.data.RequestDocumentDto;
import com.example.millcreekhoa.entity.DocumentEntity;
import com.example.millcreekhoa.entity.RequestDocumentEntity;
import com.example.millcreekhoa.service.DocumentService;
import com.example.millcreekhoa.service.RequestDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {
    @Autowired
    RequestDocumentService requestDocumentService;

    @PostMapping(value = "/requests/new")
    public RequestDocumentEntity addNewDownload(@RequestBody RequestDocumentDto requestDocumentDto) {
        return requestDocumentService.addNewRequestDocument(requestDocumentDto);
    }

    @GetMapping(value = "/requests")
    public List<RequestDocumentEntity> getAllDownloads() {
        return requestDocumentService.getAllRequests();
    }

    @GetMapping(value = "/requests/{id}")
    RequestDocumentEntity getRequestById(@PathVariable Integer id) {
        return requestDocumentService.getRequestById(id);
    }

    @PostMapping(value = "/requests/delete")
    public void deleteRequest(@RequestBody RequestDocumentDto requestDocumentDto) {
         requestDocumentService.deleteRequestDocument(requestDocumentDto);
    }
}
