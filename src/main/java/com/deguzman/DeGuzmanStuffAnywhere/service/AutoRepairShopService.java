package com.deguzman.DeGuzmanStuffAnywhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.AutoRepairShopDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateAutoShopException;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.AutoRepairShopJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.AutoRepairShop;

@Service
public class AutoRepairShopService {

	@Autowired
	private AutoRepairShopDaoImpl autoRepairShopDaoImpl;
	
	@Autowired
	private AutoRepairShopJpaDao autoShopDao;

	public List<com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop> findAllAutoRepairShopInfo() {
		return autoRepairShopDaoImpl.findAllAutoRepairShopInfo();
	}
	
	public ResponseEntity<Map<String, Object>> getAllAutoShopsPagination(
			@RequestParam(required = false) String autoShopname, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		try {

			List<AutoRepairShop> shop = autoShopDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<AutoRepairShop> pageBooks = null;

			if (autoShopname == null) {
				pageBooks = autoShopDao.findAll(paging);
			} else {
				// pageBooks = autoShopDao.findByNameContaining(autoShopname, paging);
			}

			shop = pageBooks.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("autoShops", shop);
			response.put("currentPage", pageBooks.getNumber());
			response.put("totalItems", pageBooks.getTotalElements());
			response.put("totalPages", pageBooks.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop> findAutoRepairShopByName(@PathVariable String autoShopName) {
		return autoRepairShopDaoImpl.findAutoRepairShopByName(autoShopName);
	}
	
	public List<com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop> findAutoRepairShopByZip(@PathVariable String zip) {
		return autoRepairShopDaoImpl.findAutoRepairShopByZip(zip);
	}
	
	public long getCountOfAutoRepairShops() {
		return autoRepairShopDaoImpl.getCountOfAutoRepairShops();
	}
	
	public int addAutoRepairShopInfo(com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop autoShop) throws DuplicateAutoShopException {
		return autoRepairShopDaoImpl.addAutoRepairShopInfo(autoShop);
	}
	
	public int updateAutoShopInfo(@PathVariable int auto_shop_id, @RequestBody com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop shopDetails) {
		return autoRepairShopDaoImpl.updateAutoShopInfo(auto_shop_id, shopDetails);
	}
	
	public int deleteAutoRepairShopInfo(@PathVariable int auto_shop_id) {
		return autoRepairShopDaoImpl.deleteAutoRepairShopInfo(auto_shop_id);
	}
	
	public int deleteAllAutoShops() {
		return autoRepairShopDaoImpl.deleteAllAutoShop();
	}

	public ResponseEntity<com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop> findAutoRepairShopById(
			int auto_shop_id) {
		return autoRepairShopDaoImpl.findAutoRepairShopById(auto_shop_id);
	}
}
