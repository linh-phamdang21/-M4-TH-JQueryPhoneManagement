package com.codegym.service;

import com.codegym.model.SmartPhone;

public interface SmartphoneService {
    Iterable<SmartPhone> findAll();

    SmartPhone findById(Integer id);

    SmartPhone save(SmartPhone smartPhone);

    SmartPhone remove(Integer id);
}
