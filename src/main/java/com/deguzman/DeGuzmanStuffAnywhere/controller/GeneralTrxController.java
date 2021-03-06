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

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.GeneralTrxDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.GeneralTrxInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.GeneralTransaction;
import com.deguzman.DeGuzmanStuffAnywhere.service.GeneralTrxService;

@RestController
@RequestMapping("/app/general-transactions")
@CrossOrigin
public class GeneralTrxController {

	@Autowired
	private GeneralTrxService generalTrxService;

	@GetMapping("/all")
	@CrossOrigin
	public List<GeneralTrxInfoDTO> getAllGeneralTransactionInformation() {
		return generalTrxService.findAllTransactionInformation();
	}
	
	@GetMapping("/all-transactions")
	public ResponseEntity<Map<String, Object>> getAllTransactionsPagination(@RequestParam(required = false) String paymentDate,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return generalTrxService.getAllTransactionsPagination(paymentDate, page, size);
	}

	@GetMapping("/all/type/{transaction_type_id}")
	@CrossOrigin
	public List<GeneralTrxInfoDTO> getTransactionsByType(@PathVariable long transaction_type_id) {
		return generalTrxService.findTransactionsByType(transaction_type_id);
	}

	@GetMapping("/all/user/{user_id}")
	@CrossOrigin
	public List<GeneralTrxInfoDTO> getTransactionsByUser(@PathVariable long user_id) {
		return generalTrxService.findTransactionsByUser(user_id);
	}

	@GetMapping("/transaction-dto/{transaction_id}")
	@CrossOrigin
	public ResponseEntity<GeneralTrxInfoDTO> getTrxInformationDTOById(@PathVariable long transaction_id)
			throws ResourceNotFoundException {
		return generalTrxService.findTranactionInformationDTOById(transaction_id);
	}
	
	@GetMapping("/transaction/{transaction_id}")
	@CrossOrigin
	public ResponseEntity<GeneralTransaction> getTrxInformationById(@PathVariable long transaction_id)
			throws ResourceNotFoundException {
		return generalTrxService.findTransactionInformationById(transaction_id);
	}

	@GetMapping("/get-transaction-count")
	@CrossOrigin
	public long getTransactionCcount() {
		return generalTrxService.findCountOfGeneralTransacion();
	}

	@PostMapping("/add-general-transaction-information")
	@CrossOrigin
	public int addGeneralTrasactionInformation(@RequestBody GeneralTransaction transaction)
			throws ResourceNotFoundException {
		return generalTrxService.addTransactionInformation(transaction);
	}
	
	@PutMapping("/transaction/{transaction_id}")
	@CrossOrigin
	public int updateTransactionInformation(@PathVariable long transaction_id, @RequestBody GeneralTransaction tranasctionDetails) {
		return generalTrxService.updateTransactionInformation(transaction_id, tranasctionDetails);
	}

	@DeleteMapping("/transaction/{transaction_id}")
	@CrossOrigin
	public int deleteTransactionById(@PathVariable long transaction_id) {
		return generalTrxService.deleteTransactioninformation(transaction_id);
	}

	@DeleteMapping("/delete-all-transactions")
	@CrossOrigin
	public int deleteAllTransactions() {
		return generalTrxService.deleteAllTransactions();
	}
}
