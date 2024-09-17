package com.bloodlink.jpaRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodlink.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {



}
