package com.bloodlink.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bloodlink.model.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

	@Query("SELECT COUNT(e) FROM Campaign e")
	long countCampaign();

}
