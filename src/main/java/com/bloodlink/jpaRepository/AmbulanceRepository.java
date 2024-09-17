package com.bloodlink.jpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bloodlink.model.Ambulance;

@Repository
public interface AmbulanceRepository extends JpaRepository<Ambulance, Integer> {
	
	@EntityGraph(attributePaths = {"address","phoneD"})
	List<Ambulance> findAll();

	@Query("SELECT COUNT(e) FROM Ambulance e")
	long countAmbulance();
}
