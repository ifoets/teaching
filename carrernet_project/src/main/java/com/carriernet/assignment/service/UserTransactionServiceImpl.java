package com.carriernet.assignment.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carriernet.assignment.dao.IUserTransactionRepository;
import com.carriernet.assignment.exception.CarriernetException;
import com.carriernet.assignment.model.UserTransaction;
import com.carriernet.assignment.vo.UserTransactionDto;

@Service("userTransactionService")
public class UserTransactionServiceImpl implements IUserTransactionService {
	private static final Logger LOG = LoggerFactory.getLogger(UserTransactionServiceImpl.class);
	@Autowired
	private IUserTransactionRepository iUserTransactionRepository;

	public List<UserTransactionDto> createTranaction(UserTransactionDto userTransactionDto) {

		List<UserTransaction> userTransactionList = new ArrayList<>();
		UserTransaction userTransaction = null;
		try {
			userTransaction = iUserTransactionRepository.save(getTransactionDtoToEntity(userTransactionDto));
			userTransactionList.add(userTransaction);
		} catch (PersistenceException e) {
			LOG.error("Unable to create/merge Country", e);
			new CarriernetException(e.getLocalizedMessage(), null);
		}
		return getTransactionEntityToDto(userTransactionList);
	}

	@Override
	public List<UserTransactionDto> getTransactionAcFrom(UserTransactionDto userTransactionDto) {
		List<UserTransaction> userTransactionList = null;
		try {
			userTransactionList = iUserTransactionRepository.findByAcFrom(userTransactionDto.getAcFrom());
		} catch (PersistenceException e) {
			LOG.error("Unable to create/merge Country", e);
			new CarriernetException(e.getLocalizedMessage(), null);
		}

		return getTransactionEntityToDto(userTransactionList);

	}

	@Override
	public List<UserTransactionDto> getTransactionAcFromToAcTo(UserTransactionDto userTransactionDto) {
		List<UserTransaction> userTransactionList = null;
		try {
			userTransactionList = null;// iUserTransactionRepository.findByAcFromAndAcTo(userTransactionDto.getAcFrom(),
			// userTransactionDto.getAcTo());
		} catch (PersistenceException e) {
			LOG.error("Unable to create/merge Country", e);
			new CarriernetException(e.getLocalizedMessage(), null);
		}

		return getTransactionEntityToDto(userTransactionList);

	}

	/*
	 * @Override public List<UserTransaction> updateTransaction(Integer id,
	 * UserTransactionDto UserTransactionDto) { List<UserTransaction>
	 * userTransactionList = null; try { userTransactionList = null;//
	 * iUserLoginRepository.update(userAccountDto.getId(), //
	 * userAccountDto.getUserPassword()); } catch (PersistenceException e) {
	 * LOG.error("Unable to create/merge Country", e); new
	 * CarriernetException(e.getLocalizedMessage(), null); }
	 * 
	 * return getTransactionEntityToDto(userTransactionList);
	 * 
	 * }
	 */
	public UserTransaction getTransactionDtoToEntity(UserTransactionDto userTransactionDto) {
		UserTransaction userTransaction = new UserTransaction();
		userTransaction.setWalletId(userTransactionDto.getWalletId());
		userTransaction.setAcFrom(userTransactionDto.getAcFrom());
		userTransaction.setAcTo(userTransactionDto.getAcTo());
		userTransaction.setTotalAmount(userTransactionDto.getTotalAmount());
		userTransaction.setCharge(userTransactionDto.getCharge());
		userTransaction.setCommision(userTransactionDto.getCommision());
		userTransaction.setTransferAmount(userTransactionDto.getTransferAmount());
		userTransaction.setTotalAmount(userTransactionDto.getTotalAmount());
		userTransaction.setTransType(userTransactionDto.getTransType());
		userTransaction.setTransTime(new Timestamp(System.currentTimeMillis()));
		return userTransaction;
	}

	public List<UserTransactionDto> getTransactionEntityToDto(List<UserTransaction> userTransactionList) {

		List<UserTransactionDto> list = new ArrayList<>();
		for (UserTransaction userTransaction : userTransactionList) {
			UserTransactionDto userTransactionDto = new UserTransactionDto();
			userTransactionDto.setWalletId(userTransaction.getWalletId());
			userTransactionDto.setAcFrom(userTransaction.getAcFrom());
			userTransactionDto.setAcTo(userTransaction.getAcTo());
			userTransactionDto.setTotalAmount(userTransaction.getTotalAmount());
			userTransactionDto.setCharge(userTransaction.getTotalAmount() * 0.2);
			userTransactionDto.setCommision(userTransaction.getTotalAmount() * 0.05);
			userTransactionDto.setTransferAmount(userTransaction.getTransferAmount());
			userTransaction.setTotalAmount(userTransaction.getTotalAmount());
			userTransactionDto.setTransType(userTransaction.getTransType());
			userTransactionDto.setTransTime(new Timestamp(System.currentTimeMillis()));
			list.add(userTransactionDto);
		}
		return list;
	}

	@Override
	public List<UserTransactionDto> updateTransaction(Integer walletId, UserTransactionDto userAccountDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
