package com.example.millcreekhoa.service;

import com.example.millcreekhoa.data.DocumentDto;
import com.example.millcreekhoa.entity.DocumentEntity;
import com.example.millcreekhoa.repo.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    public List<DocumentEntity> getAllDocuments() {
        // Grab all documents minus the actual item due to space and time
        return documentRepository.findAll().stream().map(document -> {
            document.setItem("");
            return document;
        }).collect(Collectors.toList());
    }

    public DocumentEntity getDocumentById(int id) {
        return documentRepository.findAllById(id);
    }

    public DocumentEntity addNewDocument(DocumentDto documentDto) {
            DocumentEntity entity = new DocumentEntity(documentDto.getName(),documentDto.getFriendlyName(),documentDto.getDescription(),documentDto.getCategory(), documentDto.getItem());
            return documentRepository.save(entity);
        }
    }

