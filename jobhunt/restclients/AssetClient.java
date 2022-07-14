package com.cg.webapp.restclients;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.webapp.model.Asset;

//import com.cts.subscription.exception.InvalidTokenException;



@FeignClient(name = "Asset",url = "http://localhost:9100/asset")
public interface AssetClient {
	
	
	
	@GetMapping(value= "/get/all")
	public  ResponseEntity<List<Asset>> getAllAssets();
	
	
	@PostMapping(value = "/create")
	public ResponseEntity<Asset>  addAsset(@RequestBody Asset asset) ;
	

	/**
	 * 
	 * @param token
	 * @param subscriptionId
	 * @return
	 * @throws InvalidTokenException
	 */
	@GetMapping("/get/{id}")
	  public ResponseEntity<Asset> getAssetById(@PathVariable("id") String id);
	
	@PutMapping("/update/{id}")
	  public ResponseEntity<Asset> updateAsset(@PathVariable("id") String id, @RequestBody Asset asset);
	    
	   
	/**
	 * 		
	 * @param token
	 * @param subscriptionId
	 * @throws InvalidTokenException
	 */
	@DeleteMapping(path = "/delete/{id}" )
	public void deleteAsset(@PathVariable ("id") String id);


//	public Asset getEmpByAssetId(String assetId);
//
//	@GetMapping("/get/{assetId}")
//	public ResponseEntity<List<Asset>> getAllAssetsById();
			
	//throws InvalidTokenException;
	
	
	
	
	
	
}


//
//@PostMapping("/create")
//public ResponseEntity<Asset> addAsset(@RequestBody Asset asset){
//	Asset assetSaved = assetServiceInterface.addAsset(asset);
//	return new ResponseEntity<Asset>(assetSaved, HttpStatus.CREATED);
//}
//
//@GetMapping("/get/all")
//public ResponseEntity<List<Asset>> getAllAssets(){
//	
//	List<Asset> listOfAllAsts = assetServiceInterface.getAllAssets();
//	return new ResponseEntity<List<Asset>>(listOfAllAsts, HttpStatus.OK);
//}
//
//
////
////if (listOfAllEmps.is Present()) {
////  return new ResponseEntity<>(listOfAllEmps.get(), HttpStatus.OK);
////} else {
////  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////}
////}
////@GetMapping("/get/{id}")
////  public ResponseEntity<Asset> getAssetById(@PathVariable("id") String id){
////	ResponseEntity<Asset> a=assetclient.getAssetById(id);
////	return a;
////}
//
//@GetMapping("/get/{id}")
//public ResponseEntity<Asset> getAssetById(@PathVariable("id") String id){
//	
//	Asset assetRetrieved = assetServiceInterface.getAssetById(id);
//	return new ResponseEntity<Asset>(assetRetrieved, HttpStatus.OK);
//}
//
//@DeleteMapping("/delete/{id}")
//public ResponseEntity<Void> deleteAssetById(@PathVariable("id") String id){
//	
//	assetServiceInterface.deleteAssetById(id);
//	return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
//}
//
//@PutMapping("/update")
//public ResponseEntity<Asset> updateEmployee(@PathVariable("id") String id,@RequestBody Asset asset){
//	Asset assetSaved = assetServiceInterface.addAsset(asset);
//	return new ResponseEntity<Asset>(assetSaved, HttpStatus.CREATED);
//}