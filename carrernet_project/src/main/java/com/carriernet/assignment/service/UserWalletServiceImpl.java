package com.carriernet.assignment.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carriernet.assignment.dao.IUserLoginRepository;
import com.carriernet.assignment.dao.IUserWalletRepository;
import com.carriernet.assignment.exception.CarriernetException;
import com.carriernet.assignment.model.UserAccount;
import com.carriernet.assignment.model.UserWallet;
import com.carriernet.assignment.utils.TransactionTypeEnum;
import com.carriernet.assignment.vo.FundTransferDto;
import com.carriernet.assignment.vo.UserTransactionDto;
import com.carriernet.assignment.vo.UserWalletDto;

@Service("userWaletService")
public class UserWalletServiceImpl implements IUserWalletService {
	private static final Logger LOG = LoggerFactory.getLogger(UserWalletServiceImpl.class);
	@Autowired
	private IUserWalletRepository iUserWalletRepository;

	@Autowired
	private IUserLoginRepository iUserLoginRepository;

	@Autowired
	private IUserTransactionService iUserTransactionService;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void fundTransfer(FundTransferDto fundTransferDto) {
		// check user login
		UserWallet fromUserWallet = iUserWalletRepository.findByAcno(fundTransferDto.getFromAc());
		UserWallet toUserWallet = iUserWalletRepository.findByAcno(fundTransferDto.getToAc());
		UserAccount fromUserAccount = iUserLoginRepository.findById(fromUserWallet.getAccountId());

		if (!fromUserAccount.isLogin()) {
			LOG.error("User is not loged in");
			new CarriernetException("User is not loged in", null);
		}

		if (fromUserWallet.getAmount() < fundTransferDto.getTransferAmout()) {
			LOG.error("User do not have sufficient balance to transfer");
			new CarriernetException("User do not have sufficient balance to transfer", null);
		}
		double transAmount = fundTransferDto.getTransferAmout();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		fromUserWallet.setAmount(fromUserWallet.getAmount() - transAmount - transAmount * 0.25);
		toUserWallet.setAmount(toUserWallet.getAmount() + transAmount);

		/* update both from and to wallet **/
		iUserWalletRepository.updateAcAmout(fromUserWallet.getAmount(), fromUserWallet.getAcno());
		iUserWalletRepository.updateAcAmout(toUserWallet.getAmount(), toUserWallet.getAcno());

		/* tranaction table commit the tranaction from both the from and to wallet */
		UserTransactionDto fromUserTransDto = new UserTransactionDto(fromUserWallet.getId(), fromUserWallet.getAcno(),
				toUserWallet.getAcno(), transAmount * 0.2, transAmount * 0.05, transAmount, fromUserWallet.getAmount(),
				TransactionTypeEnum.DEBIT, currentTime);

		UserTransactionDto toUserTransDto = new UserTransactionDto(toUserWallet.getId(), toUserWallet.getAcno(),
				fromUserWallet.getAcno(), 0.0, 0.0, transAmount, toUserWallet.getAmount(),
				TransactionTypeEnum.CREADIT, currentTime);

		iUserTransactionService.createTranaction(fromUserTransDto);
		iUserTransactionService.createTranaction(toUserTransDto);
	}

	public UserWalletDto createUserWallet(UserWalletDto userWalletDto) {

		UserWallet userWallet = null;
		try {
			userWallet = iUserWalletRepository.save(getWalletDtoToEntity(userWalletDto));
		} catch (PersistenceException e) {
			LOG.error("Unable to create/merge Country", e);
			new CarriernetException(e.getLocalizedMessage(), null);
		}

		return getWalletEntityToDto(userWallet);
	}

	@Override
	public UserWalletDto getUserWallet(UserWalletDto userWalletDto) {
		UserWallet userWallet = null;
		try {
			userWallet = iUserWalletRepository.findByAcno(userWalletDto.getAcno());
		} catch (PersistenceException e) {
			LOG.error("Unable to create/merge Country", e);
			new CarriernetException(e.getLocalizedMessage(), null);
		}

		return getWalletEntityToDto(userWallet);

	}

	@Override
	public UserWalletDto updateUserWallet(UserWalletDto userWalletDto) {
		Integer updateValue = null;
		try {
			updateValue = iUserWalletRepository.updateAcAmout(userWalletDto.getAmount(), userWalletDto.getAcno());
			if (updateValue != 1) {
				LOG.error("Unable to update money in ac " + userWalletDto.getAcno());
				new CarriernetException("Unable to update money", null);
			}
		} catch (PersistenceException e) {
			LOG.error("Unable to create/merge Country", e);
			new CarriernetException(e.getLocalizedMessage(), null);
		}

		return getWalletEntityToDto(getFromAc(userWalletDto.getAcno()));

	}

	@Override
	public UserWallet getFromAc(String acno) {
		UserWallet userWallet = null;
		try {
			userWallet = iUserWalletRepository.findByAcno(acno);
		} catch (PersistenceException e) {
			LOG.error("Unable to create/merge Country", e);
			new CarriernetException(e.getLocalizedMessage(), null);
		}

		return userWallet;

	}

	@Override
	public List<UserWalletDto> getAllUserWallet() {
		List<UserWallet> UserWalletDtoList = null;
		List<UserWalletDto> userWalletDtoList = new ArrayList<>();
		try {
			UserWalletDtoList = iUserWalletRepository.findAll();
		} catch (PersistenceException e) {
			LOG.error("Unable to create/merge Country", e);
			new CarriernetException(e.getLocalizedMessage(), null);
		}

		for (UserWallet userWallet : UserWalletDtoList) {
			userWalletDtoList.add(getWalletEntityToDto(userWallet));
		}
		return userWalletDtoList;

	}

	public UserWallet getWalletDtoToEntity(UserWalletDto userWalletDto) {
		UserWallet userWallet = new UserWallet();
		userWallet.setAccountId(userWalletDto.getAccountId());
		userWallet.setAcno(userWalletDto.getAcno());
		userWallet.setUserName(userWalletDto.getUserName());
		userWallet.setAmount(userWalletDto.getAmount());
		return userWallet;
	}

	public UserWalletDto getWalletEntityToDto(UserWallet userWallet) {

		UserWalletDto userWalletDto = new UserWalletDto();
		userWalletDto.setAccountId(userWallet.getAccountId());
		userWalletDto.setAcno(userWallet.getAcno());
		userWalletDto.setUserName(userWallet.getUserName());
		userWalletDto.setAmount(userWallet.getAmount());
		return userWalletDto;
	}

}
