package com.cg.webapp.exception;
@SuppressWarnings("serial")
public class ApplicantNotFoundException extends Exception {

	public ApplicantNotFoundException()
	{
		//Default Constructor
	}
	
	public ApplicantNotFoundException(String message)
	{
		super(message);
	}



}