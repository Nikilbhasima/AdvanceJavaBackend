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

	@Query("SELECT rb.acceptedList FROM RequestBlood rb WHERE rb.id = :requestId")
    List<Donor> findDonorsByRequestBloodId( int requestId);

	@Query("SELECT COUNT(rb) FROM RequestBlood rb WHERE rb.requester.id = :donorId")
	int countRequestsByRequester(int donorId);

//    @Query("SELECT COUNT(rb) FROM RequestBlood rb JOIN rb.acceptedList d WHERE d.id = :donorId")
	@Query("SELECT COUNT(rb) FROM RequestBlood rb JOIN rb.acceptedList d WHERE d.id = :donorId AND rb.requester.id != :donorId")
	int countRequestsByAcceptedDonor(int donorId);

}
