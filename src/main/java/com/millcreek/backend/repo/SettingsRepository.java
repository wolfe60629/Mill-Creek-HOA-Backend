package com.millcreek.backend.repo;

import com.millcreek.backend.entity.SettingsEntity;
import org.springframework.data.repository.CrudRepository;

public interface SettingsRepository extends CrudRepository<SettingsEntity, Integer> {
    SettingsEntity getBySettingName (final String settingName);
}
