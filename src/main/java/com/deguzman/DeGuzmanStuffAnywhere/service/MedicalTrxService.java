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
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.MedicalTrxDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.MedicalTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.MedicalTrxJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.MedicalTransaction;

@Service
public class MedicalTrxService {

	@Autowired
	private MedicalTrxDaoImpl medicalTrxDaoImpl;
	
	@Autowired
	private MedicalTrxJpaDao medicalTrxDao;
	
	public List<MedicalTrxInfoDTO> findAllMedicalTransactionInformation() {
		return medicalTrxDaoImpl.findAllMedicalTransactionInformation();
	}
	
	public ResponseEntity<Map<String, Object>> getAllTransactionsPagination(@RequestParam(required = false) String paymentDate,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		try {

			List<MedicalTransaction> shop = medicalTrxDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<MedicalTransaction> pageBooks = null;

			if (paymentDate == null) {
				pageBooks = medicalTrxDao.findAll(paging);
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
	
	public List<MedicalTrxInfoDTO> findAllMedicalTranactionsByFacility(@PathVariable int facility_id) {
		return medicalTrxDaoImpl.findMedicalTransactionsByFacility(facility_id);
	}
	
	public List<MedicalTrxInfoDTO> findMedicalTransactionsByType(@PathVariable long transaction_type_id) {
		return medicalTrxDaoImpl.findMedicalTransactionsByType(transaction_type_id);
	}
	
	public List<MedicalTrxInfoDTO> findmedicalTransactionsByUser(@PathVariable long user_id) {
		return medicalTrxDaoImpl.findAllMedicalTransactionbyUser(user_id);
	}
	
	public ResponseEntity<MedicalTrxInfoDTO> findMedicalTransasctionInformationDTOById(@PathVariable long medical_transaction_id) throws ResourceNotFoundException {
		return medicalTrxDaoImpl.findMedicalTransactionInformationDTOById(medical_transaction_id);
	}
	
	public long getCountOfMedicalTransactions() {
		return medicalTrxDaoImpl.getCountOfMedicalTransactions();
	}
	
	public int addMedicalTranactionInformation(com.deguzman.DeGuzmanStuffAnywhere.model.MedicalTransaction medicalTransaction) throws ResourceNotFoundException {
		return medicalTrxDaoImpl.addMedicalTransactionInformation(medicalTransaction);
	}
	
	public int updateMedicalTransaction(long medical_transaction_id, com.deguzman.DeGuzmanStuffAnywhere.model.MedicalTransaction medicalTransactionDetails) {
		return medicalTrxDaoImpl.updateMedicalTransaction(medical_transaction_id, medicalTransactionDetails);
	}
	
	public int deleteMedicalTransactionInformation(long medical_transaction_id) {
		return medicalTrxDaoImpl.deleteMedicalTraansactionInformation(medical_transaction_id);
	}
	
	public int deleteAllMedicalTransactions() {
		return medicalTrxDaoImpl.deleteAllMedicalTransactions();
	}
}
