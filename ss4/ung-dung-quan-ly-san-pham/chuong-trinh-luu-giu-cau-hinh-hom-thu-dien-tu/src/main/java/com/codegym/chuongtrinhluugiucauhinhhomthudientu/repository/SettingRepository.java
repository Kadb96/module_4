package com.codegym.chuongtrinhluugiucauhinhhomthudientu.repository;

import com.codegym.chuongtrinhluugiucauhinhhomthudientu.model.Setting;
import org.springframework.stereotype.Repository;

@Repository
public class SettingRepository implements ISettingRepository {
    static Setting savedSetting = new Setting("Vietnamese", 5, true,"Sincerly, Vũ");

    @Override
    public boolean save(Setting setting) {
        savedSetting = setting;
        return true;
    }

    @Override
    public Setting show() {
        return savedSetting;
    }
}
