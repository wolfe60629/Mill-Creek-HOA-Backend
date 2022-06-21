package com.example.millcreekhoa.repo;

import com.example.millcreekhoa.entity.SettingsEntity;
import com.example.millcreekhoa.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface SettingsRepository extends CrudRepository<SettingsEntity, Integer> {
    SettingsEntity getBySettingName (final String settingName);
}
