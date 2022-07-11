package com.cg.webapp.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.webapp.model.Applicant;
import com.cg.webapp.repository.ApplicantRepository;

@RestController
public class ApplicantController {
	
	@Autowired
	public ApplicantRepository applicantRepository;
	
	@GetMapping(value= "/get")
	public List<Applicant> getAllApplicant(){
		
		return applicantRepository.findAll();
		
	}
	
	
	
	@PostMapping(value = "/create")
	public String createStudent(@RequestBody Applicant applicant) {
		
		Applicant insertedApplicant = applicantRepository.insert(applicant);
		
		return "Applicant created"+ insertedApplicant.getname();
	}
	
	@PutMapping("/update")
	  public Applicant updateApplicant(@RequestBody Applicant applicant) {
		
		applicantRepository.save(applicant);
		return applicant;
	  }
	
	
	 
	@DeleteMapping("/delete/{id}")
	public void deleteApplicant(@PathVariable Applicant id){
	applicantRepository.delete(id);
	
    }
	
	
	@GetMapping("/get/{id}")
	  public ResponseEntity<Applicant> getApplicantById(@PathVariable("id") String id) {
	    Optional<Applicant> applicantData = applicantRepository.findById(id);

	    if (applicantData.isPresent()) {
	      return new ResponseEntity<>(applicantData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@PutMapping("/update/{id}")
	  public ResponseEntity<Applicant> updateApplicant(@PathVariable("id") String id, @RequestBody Applicant applicant) {
	    Optional<Applicant> applicantData = applicantRepository.findById(id);

	    if (applicantData.isPresent()) {
	      Applicant _applicant = applicantData.get();
	      _applicant.setName(applicant.getname());
	      _applicant.setAddress(applicant.getAddress());
	      _applicant.setGender(applicant.getGender());
	      _applicant.setContact(applicant.getContact());
	      _applicant.setEmailId(applicant.getEmailId());
	      _applicant.setPassOutYear(applicant.getPassOutYear());
	      _applicant.setBranch(applicant.getBranch());
	      _applicant.setUniversityName(applicant.getUniversityName());
	      
	      
	      return new ResponseEntity<>(applicantRepository.save(_applicant), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
}