package com.bloodlink.jpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bloodlink.model.Donor;
import com.bloodlink.model.RequestBlood;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {

	Donor findByPhoneAndPassword(String phone, String password);

	boolean existsByPhoneAndPassword(String phone, String password);

    @Query("SELECT d.gmail FROM Donor d WHERE d.bloodGrp = :bloodGrp")
	List<String> findGmailByBloodGrp(String bloodGrp);

    @Query("SELECT rb FROM RequestBlood rb JOIN rb.acceptedList d WHERE d.id = :donorId")
	List<RequestBlood> findParticipatedRequestsByDonor(int donorId);

    @Query("SELECT COUNT(e) FROM Donor e")
	long getNumberOfUser();




	boolean existsByPhone(String phone);






    
    

}
