package com.millcreek.backend.service;

import com.millcreek.backend.repo.SettingsRepository;
import com.millcreek.backend.entity.SettingsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

