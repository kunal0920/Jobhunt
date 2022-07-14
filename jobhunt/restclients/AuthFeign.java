package com.cg.webapp.restclients;
//package com.cg.hrms.employee.restclients;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//
//import com.cg.hrms.employee.model.ValidateToken;
//
///**Interface to connect with authentication service*/
//@FeignClient(name = "${authservice.client.name}",
//url = "${authservice.client.url}")
//public interface AuthFeign {
//
//	/**
//	 * @param token
//	 * @return
//	 */
//	@GetMapping(value = "/validate")
//	public ResponseEntity<ValidateToken> getValidity(@RequestHeader("Authorization") final String token);
//}