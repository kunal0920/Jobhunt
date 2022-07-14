package com.cg.webapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.webapp.exception.ApplicantNotFoundException;
import com.cg.webapp.exception.NoProperDataException;
import com.cg.webapp.model.Applicant;

public interface ApplicantService {

public ResponseEntity<Applicant> addApplicant(@RequestBody Applicant applicant) throws NoProperDataException;

public ResponseEntity<List<Applicant>> getAllApplicant() throws ApplicantNotFoundException;

public ResponseEntity<Applicant> getApplicantById(@PathVariable long id) throws ApplicantNotFoundException;


ResponseEntity<Applicant> deleteApplicantById(long id) throws ApplicantNotFoundException;

ResponseEntity<Applicant> updateApplicant(Applicant applicant, long id) throws ApplicantNotFoundException;









}
	

