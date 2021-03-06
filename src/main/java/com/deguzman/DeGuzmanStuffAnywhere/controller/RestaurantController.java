package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.RestaurantDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.RestaurantInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateRestaurantException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidRestaurantException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Restaurant;
import com.deguzman.DeGuzmanStuffAnywhere.service.RestaurantInfoService;

@RestController
@RequestMapping("/app/restaurants")
@CrossOrigin
public class RestaurantController {
	
	@Autowired
	private RestaurantInfoService restaurantInfoService;

	@GetMapping("/all")
	@CrossOrigin
	public List<RestaurantInfoDTO> getAllRestaurantInformation() {
		return restaurantInfoService.findAllRestaurants();
	}
	
	@GetMapping("/all-restaurants")
	public ResponseEntity<Map<String, Object>> getAllRestaurantsPagination(@RequestParam(required = false) String name,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return restaurantInfoService.getAllRestaurantsPagination(name, page, size);
	}

	@GetMapping("/restaurant/type/{restaurant_type_id}")
	@CrossOrigin
	public List<RestaurantInfoDTO> getAllRestaurantInformationByType(@PathVariable int restaurant_type_id) {
		return restaurantInfoService.findAllRestaurantsByType(restaurant_type_id);
	}

	@GetMapping("/restaurant/zip/{zip}")
	@CrossOrigin
	public List<RestaurantInfoDTO> getAllRestaurantInformationByZip(@PathVariable String zip) {
		return restaurantInfoService.findRestaurantByZipCode(zip);
	}

	@GetMapping("/restaurant/descr/{descr}")
	@CrossOrigin
	public List<RestaurantInfoDTO> getAllRestaurantInformationByDescr(@PathVariable String descr) {
		return restaurantInfoService.findRestaurantsByDescr(descr);
	}

	@GetMapping("/restaurant-dto/{restaurant_id}")
	@CrossOrigin
	public ResponseEntity<RestaurantInfoDTO> getRestaurantDTOInfoById(@PathVariable int restaurant_id)
			throws InvalidRestaurantException {
		return restaurantInfoService.findRestaurantById(restaurant_id);
	}
	
	@GetMapping("/restaurant/{restaurant_id}")
	public ResponseEntity<RestaurantInfoDTO> getRestaurantInfoById(@PathVariable int restaurant_id) throws InvalidRestaurantException {
		return restaurantInfoService.findRestaurantById(restaurant_id);
	}
	

	@GetMapping("/restaurant/name/{name}")
	@CrossOrigin
	public ResponseEntity<RestaurantInfoDTO> getRestaurantInformationByName(@PathVariable String name) {
		return restaurantInfoService.findRestaurantByName(name);
	}

	@GetMapping("/restaurant-count")
	@CrossOrigin
	public long getRestaurantCount() {
		return restaurantInfoService.getRestaurantCount();
	}

	@PostMapping("/add-restaurant-information")
	@CrossOrigin
	public int addRestaurantInformation(@RequestBody Restaurant restaurant) throws ResourceNotFoundException, DuplicateRestaurantException {
		return restaurantInfoService.addRestaurantInformation(restaurant);
	}

	@PutMapping("/restaurant/{restaurant_id}")
	@CrossOrigin
	public int updateRestaurantInformation(@PathVariable int restaurant_id, @RequestBody Restaurant restaurantDetails) throws ResourceNotFoundException {
		return restaurantInfoService.updateRestaurantInformation(restaurant_id, restaurantDetails);
	}
	
	@DeleteMapping("/restaurant/{restaurant_id}")
	@CrossOrigin
	public int deleteRestaurantInformationById(@PathVariable int restaurant_id) {
		return restaurantInfoService.deleteRestaurantInformation(restaurant_id);
	}

	@DeleteMapping("/delete-all-restaurant")
	@CrossOrigin
	public int deleteAllRestaurantInformation() {
		return restaurantInfoService.deleteAllRestaurantInformation();
	}
}
