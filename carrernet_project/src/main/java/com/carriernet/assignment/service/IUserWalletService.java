package com.carriernet.assignment.service;

import java.util.List;

import com.carriernet.assignment.model.UserWallet;
import com.carriernet.assignment.vo.FundTransferDto;
import com.carriernet.assignment.vo.UserWalletDto;

public interface IUserWalletService {

	public UserWalletDto createUserWallet(UserWalletDto userWalletDto);

	public UserWalletDto getUserWallet(UserWalletDto userWalletDto);

	public UserWalletDto updateUserWallet(UserWalletDto userWalletDto);

	public List<UserWalletDto> getAllUserWallet();

	public UserWallet getFromAc(String acno);

	public void fundTransfer(FundTransferDto fundTransferDto);
}
