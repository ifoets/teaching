package com.carriernet.assignment.service;

import com.carriernet.assignment.model.UserAccount;
import com.carriernet.assignment.vo.UserAccountDto;

public interface IUserLoginService {

	public UserAccountDto createUser(UserAccountDto userAccountDto);

	public UserAccountDto getUser(UserAccountDto userAccountDto);

	public Integer updatePassword(UserAccountDto userAccountDto);

	public UserAccount loginUser(UserAccount UserAccount);
	
	public UserAccountDto logout(UserAccountDto userAccountDto);

}
