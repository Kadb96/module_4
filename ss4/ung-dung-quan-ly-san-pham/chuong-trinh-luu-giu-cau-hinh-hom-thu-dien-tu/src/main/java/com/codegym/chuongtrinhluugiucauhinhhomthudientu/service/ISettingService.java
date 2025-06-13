package com.codegym.chuongtrinhluugiucauhinhhomthudientu.service;

import com.codegym.chuongtrinhluugiucauhinhhomthudientu.model.Setting;

public interface ISettingService {
    public boolean save(Setting setting);
    public Setting show();
}
