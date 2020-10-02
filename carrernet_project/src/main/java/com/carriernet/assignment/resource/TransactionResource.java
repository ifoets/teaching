package com.carriernet.assignment.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carriernet.assignment.service.UserTransactionServiceImpl;
import com.carriernet.assignment.vo.UserAccountDto;
import com.carriernet.assignment.vo.UserTransactionDto;

@RestController("transactionResource")
@RequestMapping(value = "/user/transaction")
public class TransactionResource extends AbstactResource {

	@Autowired
	private UserTransactionServiceImpl userTransactionService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<UserTransactionDto> createTransaction(@RequestBody UserTransactionDto transactionDto) {
		return userTransactionService.createTranaction(transactionDto);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UserTransactionDto> getTranaction(@RequestBody UserTransactionDto transactionDto) {
		return userTransactionService.getTransactionAcFrom(transactionDto);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") Integer id, @RequestBody UserAccountDto userAccountVO) {
	}

}
