package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.deguzman.DeGuzmanStuffAnywhere.model.RestaurantType;

public interface RestaurantTypeDao {

	public List<RestaurantType> findAllRestaurantTypeInformation();

	public ResponseEntity<RestaurantType> findRestaurantInformationById(@PathVariable int restaurant_type_id);

	public ResponseEntity<RestaurantType> findRestaurantTypeByDescr(@PathVariable String restaurantDescr);

	public long getRestaurantTypeCount();
}
