package com.codegym.repository;

import com.codegym.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<SmartPhone, Integer> {
}
