package com.carriernet.assignment.service;

import java.util.List;

import com.carriernet.assignment.vo.UserTransactionDto;

public interface IUserTransactionService {

	public List<UserTransactionDto> createTranaction(UserTransactionDto transactionDto);

	public List<UserTransactionDto> getTransactionAcFrom(UserTransactionDto userAccountDto);

	public List<UserTransactionDto> getTransactionAcFromToAcTo(UserTransactionDto userAccountDto);

	public List<UserTransactionDto> updateTransaction(Integer walletId, UserTransactionDto userAccountDto);
}
