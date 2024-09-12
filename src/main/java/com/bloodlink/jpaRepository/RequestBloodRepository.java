package com.bloodlink.jpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bloodlink.model.Donor;
import com.bloodlink.model.RequestBlood;

@Repository
public interface RequestBloodRepository extends JpaRepository<RequestBlood, Integer> {

	List<RequestBlood> findByRequester(Donor donor);

	List<RequestBlood> findByBloodGrp(String bloodGrp);

	List<RequestBlood> findAllById(int id);

//	 @Query("SELECT d FROM Donor d JOIN d.acceptedList rb WHERE rb.id = :requestId")
//	  List<Donor> findDonorsByRequestId(int requestId);


	@Query("SELECT rb.acceptedList FROM RequestBlood rb WHERE rb.id = :requestId")
    List<Donor> findDonorsByRequestBloodId( int requestId);

}
