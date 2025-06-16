package com.codegym.tokhaiyte.service;

import com.codegym.tokhaiyte.model.MedicalForm;

import java.util.ArrayList;
import java.util.List;

public class MedicalFormService implements IMedicalFormService{
    private final List<MedicalForm> medicalFormList = new ArrayList<>();
    private final MedicalForm medicalForm = new MedicalForm();

    @Override
    public List<MedicalForm> findAll() {
        return medicalFormList;
    }

    @Override
    public void save(MedicalForm MedicalForm) {
        medicalFormList.add(MedicalForm);
    }

    @Override
    public MedicalForm findById(long id) {
        return medicalForm;
    }

    @Override
    public void update(long id, MedicalForm medicalForm) {
        medicalFormList.set(Integer.parseInt(String.valueOf(id)), medicalForm);
    }

    @Override
    public void remove(long id) {
        medicalFormList.remove(Integer.parseInt(String.valueOf(id)));
    }
}
