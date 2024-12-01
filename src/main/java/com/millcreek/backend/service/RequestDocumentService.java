package com.millcreek.backend.service;

import com.millcreek.backend.entity.RequestDocumentEntity;
import com.millcreek.backend.repo.RequestDocumentRepository;
import com.millcreek.backend.data.RequestDocumentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestDocumentService {

    @Autowired
    RequestDocumentRepository requestDocumentRepository;

    public List<RequestDocumentEntity> getAllRequests() {
        // Return all items except for the document itself for performance
        return requestDocumentRepository.findAll().stream().map((requestDocumentEntity -> {
            requestDocumentEntity.setItem("");
            return requestDocumentEntity;
        })).collect(Collectors.toList());
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

