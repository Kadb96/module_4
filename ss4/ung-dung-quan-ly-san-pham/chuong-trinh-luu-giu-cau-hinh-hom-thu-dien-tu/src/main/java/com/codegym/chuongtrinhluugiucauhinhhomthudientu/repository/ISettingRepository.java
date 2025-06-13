package com.codegym.chuongtrinhluugiucauhinhhomthudientu.repository;

import com.codegym.chuongtrinhluugiucauhinhhomthudientu.model.Setting;

public interface ISettingRepository {
    public boolean save(Setting setting);
    public Setting show();
}
