package com.codegym.tokhaiyte.service;

import com.codegym.tokhaiyte.model.MedicalForm;

import java.util.List;

public interface IMedicalFormService {
    List<MedicalForm> findAll();
    void save(MedicalForm MedicalForm);
    MedicalForm findById(long id);
    void update(long id, MedicalForm medicalForm);
    void remove(long id);
}
