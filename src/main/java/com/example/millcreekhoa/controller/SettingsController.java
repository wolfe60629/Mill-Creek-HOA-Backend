package com.example.millcreekhoa.controller;

import com.example.millcreekhoa.data.DocumentDto;
import com.example.millcreekhoa.entity.DocumentEntity;
import com.example.millcreekhoa.entity.SettingsEntity;
import com.example.millcreekhoa.service.DocumentService;
import com.example.millcreekhoa.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
