package com.example.millcreekhoa.service;

import com.example.millcreekhoa.data.DocumentDto;
import com.example.millcreekhoa.entity.DocumentEntity;
import com.example.millcreekhoa.entity.SettingsEntity;
import com.example.millcreekhoa.repo.DocumentRepository;
import com.example.millcreekhoa.repo.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SettingsService {

    @Autowired
    SettingsRepository settingsRepository;

    public SettingsEntity getSettingBySettingName(String name) {
        return settingsRepository.getBySettingName(name);
    }

    public SettingsEntity saveSetting(SettingsEntity entity) {
            return settingsRepository.save(entity);
        }
    }

