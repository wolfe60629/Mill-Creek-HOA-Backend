package com.millcreek.backend.controller;

import com.millcreek.backend.entity.SettingsEntity;
import com.millcreek.backend.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class SettingsController {

    @Autowired
    SettingsService settingsService;

   @PostMapping(value = "/settings/save")
    public SettingsEntity saveSetting(@RequestBody SettingsEntity entity) {
      return settingsService.saveSetting(entity);
   }

   @GetMapping(value = "/settings/{settingName}")
   SettingsEntity getSettingBySettingName(@PathVariable String settingName) {
       return settingsService.getSettingBySettingName(settingName);
   }
}
