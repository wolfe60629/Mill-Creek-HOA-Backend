package com.example.millcreekhoa.service;

import com.example.millcreekhoa.data.DocumentDto;
import com.example.millcreekhoa.data.RequestDocumentDto;
import com.example.millcreekhoa.entity.DocumentEntity;
import com.example.millcreekhoa.entity.RequestDocumentEntity;
import com.example.millcreekhoa.repo.DocumentRepository;
import com.example.millcreekhoa.repo.RequestDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestDocumentService {

    @Autowired
    RequestDocumentRepository requestDocumentRepository;

    public List<RequestDocumentEntity> getAllRequests() {
        return requestDocumentRepository.findAll();
    }

    public RequestDocumentEntity getRequestById(int id) {
        return requestDocumentRepository.findAllById(id);
    }

    public RequestDocumentEntity addNewRequestDocument(RequestDocumentDto requestDocumentDto) {
            RequestDocumentEntity entity = new RequestDocumentEntity(
                    requestDocumentDto.getName(),
                    requestDocumentDto.getFriendlyName(),
                    requestDocumentDto.getDescription(),
                    requestDocumentDto.getCategory(),
                    requestDocumentDto.getItem(),
                    requestDocumentDto.getEditableColumns());
            return requestDocumentRepository.save(entity);
        }

        public void deleteRequestDocument(RequestDocumentDto requestDocumentDto) {
           RequestDocumentEntity entity = requestDocumentRepository.findByNameAndAndDescription(
                   requestDocumentDto.getName(), requestDocumentDto.getDescription()
           ).get(0);

            requestDocumentRepository.deleteById(entity.getId());
        }
    }

