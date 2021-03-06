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

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.GeneralTrxDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.GeneralTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.GeneralTrxJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.GeneralTransaction;

@Service
public class GeneralTrxService {

	@Autowired
	private GeneralTrxDaoImpl generalTrxDaoImpl;
	
	@Autowired
	private GeneralTrxJpaDao generalTrxDao;
	
	public List<GeneralTrxInfoDTO> findAllTransactionInformation() {
		return generalTrxDaoImpl.findAllTransactionInformation();
	}
	
	public ResponseEntity<Map<String, Object>> getAllTransactionsPagination(@RequestParam(required = false) String paymentDate,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		try {

			List<GeneralTransaction> shop = generalTrxDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<GeneralTransaction> pageBooks = null;

			if (paymentDate == null) {
				pageBooks = generalTrxDao.findAll(paging);
			} else {
				// pageBooks = autoShopDao.findByNameContaining(autoShopname, paging);
			}

			shop = pageBooks.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("transactions", shop);
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
	
	public List<GeneralTrxInfoDTO> findTransactionsByUser(@PathVariable long user_id) {
		return generalTrxDaoImpl.findTransactionsByUser(user_id);
	}
	
	public List<GeneralTrxInfoDTO> findTransactionsByType(@PathVariable long transaction_type_id) {
		return generalTrxDaoImpl.findTransactionsByType(transaction_type_id);
	}
	
	public ResponseEntity<GeneralTrxInfoDTO> findTranactionInformationDTOById(@PathVariable long transaction_id) throws ResourceNotFoundException {
		return generalTrxDaoImpl.findTransactionInformationDTOById(transaction_id);
	}
	
	public long findCountOfGeneralTransacion() {
		return generalTrxDaoImpl.findCountOfGeneralTransaction();
	}
	
	public int addTransactionInformation(@RequestBody com.deguzman.DeGuzmanStuffAnywhere.model.GeneralTransaction transaction) throws ResourceNotFoundException {
		return generalTrxDaoImpl.addTransactionInformation(transaction);
	}
	
	public int updateTransactionInformation(@PathVariable Long transaction_id, @RequestBody com.deguzman.DeGuzmanStuffAnywhere.model.GeneralTransaction transaction) {
		return generalTrxDaoImpl.updateTransactionInformation(transaction_id, transaction);
	}
	
	public int deleteTransactioninformation(@PathVariable long transaction_id) {
		return generalTrxDaoImpl.deleteTransactionInformation(transaction_id);
	}
	
	public int deleteAllTransactions() {
		return generalTrxDaoImpl.deleteAllTransactions();
	}

	public ResponseEntity<com.deguzman.DeGuzmanStuffAnywhere.model.GeneralTransaction> findTransactionInformationById(
			long transaction_id) throws ResourceNotFoundException {
		return generalTrxDaoImpl.findTransactionInformationById(transaction_id);
	}
}
