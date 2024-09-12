package com.bloodlink.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodlink.model.DriverPhone;

@Repository
public interface DriverPhoneRepository extends JpaRepository<DriverPhone, Integer>{

}
