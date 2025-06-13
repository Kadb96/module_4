package com.codegym.chuongtrinhluugiucauhinhhomthudientu.service;

import com.codegym.chuongtrinhluugiucauhinhhomthudientu.model.Setting;
import com.codegym.chuongtrinhluugiucauhinhhomthudientu.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingService implements ISettingService {
    @Autowired
    SettingRepository settingRepository;

    @Override
    public boolean save(Setting setting) {
        return settingRepository.save(setting);
    }

    @Override
    public Setting show() {
        return settingRepository.show();
    }
}
