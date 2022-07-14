package com.cg.webapp.service;
import java.util.ArrayList;
import java.util.List;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.webapp.exception.ApplicantNotFoundException;
import com.cg.webapp.exception.NoProperDataException;
import com.cg.webapp.model.Applicant;
import com.cg.webapp.repository.ApplicantRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	private ApplicantRepository applicantRepository;
	

	@Override
	public ResponseEntity<Applicant> addApplicant(@RequestBody Applicant applicant) throws NoProperDataException {
		
		//log.info("start");
		if(applicant!=null) 
		{
			applicantRepository.save(applicant);
			System.out.println("applicant added");
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return ResponseEntity.ok(applicant);
		
	}


	

	@Override
	public ResponseEntity<List<Applicant>> getAllApplicant() throws ApplicantNotFoundException {

		List<Applicant> applicants =new ArrayList<>();
		applicants =applicantRepository.findAll();
		if(applicants.size()==0){
			throw new ApplicantNotFoundException("Applicant is empty");
		}
		else{
			//log.info("get all Applicants from the list");
			return new  ResponseEntity<>(applicantRepository.findAll(),HttpStatus.OK);
		}
}

	@Override
	public ResponseEntity<Applicant> getApplicantById(long id) throws ApplicantNotFoundException{
		Applicant applicants=applicantRepository.findById(id).orElseThrow(()-> new  ApplicantNotFoundException("applicant Not Found"+id));
		
		return ResponseEntity.ok().body(applicants);
	}



	@Override
	public ResponseEntity<Applicant> deleteApplicantById(long id) throws ApplicantNotFoundException{
		Applicant applicants=applicantRepository.deleteApplicantById(id).orElseThrow(()-> new  ApplicantNotFoundException("applicant Not Found"+id));
		
		return ResponseEntity.ok().body(applicants);
	}


	@Override
	public ResponseEntity<Applicant> updateApplicant(Applicant applicant, long id) throws ApplicantNotFoundException {
		
        Applicant applicants=applicantRepository.findById(id).orElseThrow(()-> new ApplicantNotFoundException("applicant not "+id));
		
		
		applicant.setName(applicant.getname());
		applicant.setAddress(applicant.getAddress());
		applicant.setGender(applicant.getGender());
		applicant.setContact(applicant.getContact());
		applicant.setEmailId(applicant.getEmailId());
		applicant.setPassOutYear(applicant.getPassOutYear());
		applicant.setBranch(applicant.getBranch());
		applicant.setUniversityName(applicant.getUniversityName());
		
		
		final Applicant updatedApplicant =applicantRepository.save(applicant);
		return ResponseEntity.ok(updatedApplicant);
		
	
	
	}


	
























	

	
	


	







	

	

}