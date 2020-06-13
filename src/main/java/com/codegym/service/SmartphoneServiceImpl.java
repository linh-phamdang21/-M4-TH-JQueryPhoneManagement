package com.codegym.service;

import com.codegym.model.SmartPhone;
import com.codegym.repository.SmartphoneRepository;
import org.omg.CORBA.PolicyHolder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;

public class SmartphoneServiceImpl implements SmartphoneService{

    @Autowired
    SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<SmartPhone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(Integer id) {
        SmartPhone smartPhone = smartphoneRepository.findOne(id);
        if (smartPhone != null){
            return smartPhone;
        }
        return null;
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        smartphoneRepository.save(smartPhone);
        return smartPhone;
    }

    @Override
    public SmartPhone remove(Integer id) {
        SmartPhone smartPhone = smartphoneRepository.findOne(id);
        smartphoneRepository.delete(smartPhone);
        return smartPhone;
    }
}
