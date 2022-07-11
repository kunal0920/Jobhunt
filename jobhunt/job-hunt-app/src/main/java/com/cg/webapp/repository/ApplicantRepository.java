package com.cg.webapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.webapp.model.Applicant;
@Repository
public interface ApplicantRepository extends MongoRepository<Applicant,String>{

}
