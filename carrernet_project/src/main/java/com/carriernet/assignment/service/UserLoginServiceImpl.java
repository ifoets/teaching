package com.carriernet.assignment.service;

import java.sql.Timestamp;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carriernet.assignment.dao.IUserLoginRepository;
import com.carriernet.assignment.exception.CarriernetException;
import com.carriernet.assignment.model.UserAccount;
import com.carriernet.assignment.vo.UserAccountDto;

@Service("userLoginService")
public class UserLoginServiceImpl implements IUserLoginService {
	private static final Logger LOG = LoggerFactory.getLogger(UserLoginServiceImpl.class);
	@Autowired
	private IUserLoginRepository iUserLoginRepository;

	public UserAccountDto createUser(UserAccountDto userAccountDto) {

		UserAccount userAccount = null;
		try {
			userAccount = iUserLoginRepository.save(getUserDtoToEntity(userAccountDto));
		} catch (PersistenceException e) {
			LOG.error("Unable to create/merge Country", e);
			new CarriernetException(e.getLocalizedMessage(), null);
		}

		return getUserEntityToDto(userAccount);
	}

	@Override
	public UserAccountDto getUser(UserAccountDto userAccountDto) {
		UserAccount userAccount = null;
		try {
			userAccount = iUserLoginRepository.findByUserNameAndUserPassword(userAccountDto.getUserName(),
					userAccountDto.getUserPassword());
		} catch (PersistenceException e) {
			LOG.error("Unable to create/merge Country", e);
			new CarriernetException(e.getLocalizedMessage(), null);
		}

		return getUserEntityToDto(loginUser(userAccount));

	}

	@Override
	public Integer updatePassword(UserAccountDto userAccountDto) {
		Integer updateValue = null;
		try {
			updateValue = iUserLoginRepository.updatePassword(userAccountDto.getUserName(),
					userAccountDto.getUserPassword());
		} catch (PersistenceException e) {
			LOG.error("Unable to create/merge Country", e);
			new CarriernetException(e.getLocalizedMessage(), null);
		}

		return updateValue;

	}

	@Override
	public UserAccount loginUser(UserAccount userAccount) {
		Integer updateValue = null;
		userAccount.setLogin(true);
		userAccount.setLoginTime(new Timestamp(System.currentTimeMillis()));
		try {
			updateValue = iUserLoginRepository.updateLoginUser(userAccount.getLoginTime(), userAccount.isLogin(),
					userAccount.getId());
			if (updateValue != 1) {
				LOG.error("User Unable to login");
				throw new CarriernetException("User Unable to login", null);
			}
			userAccount = iUserLoginRepository.findById(userAccount.getId());
		} catch (PersistenceException e) {
			LOG.error("Unable to create/merge Country", e);
			new CarriernetException(e.getLocalizedMessage(), null);
		}

		return userAccount;

	}

	@Override
	public UserAccountDto logout(UserAccountDto userAccountDto) {
		Integer logout = null;
		userAccountDto.setLogin(false);
		userAccountDto.setLoginTime(new Timestamp(System.currentTimeMillis()));
		UserAccount userAccount = null;
		try {
			logout = iUserLoginRepository.logout(userAccountDto.getLoginTime(), userAccountDto.isLogin(),
					userAccountDto.getId());
			if (logout != 1) {
				LOG.error("User Unable to loout");
				throw new CarriernetException("User Unable to logout", null);
			}
			userAccount = iUserLoginRepository.findById(userAccountDto.getId());
		} catch (PersistenceException e) {
			LOG.error("Unable to create/merge Country", e);
			new CarriernetException(e.getLocalizedMessage(), null);
		}
		return getUserEntityToDto(userAccount);
	}

	public UserAccount getUserDtoToEntity(UserAccountDto userAccountDto) {
		UserAccount userAccount = new UserAccount();
		userAccount.setLogin(false);
		userAccount.setLoginTime(new Timestamp(System.currentTimeMillis()));
		userAccount.setUserName(userAccountDto.getUserName());
		userAccount.setUserPassword(userAccountDto.getUserPassword());
		return userAccount;
	}

	public UserAccountDto getUserEntityToDto(UserAccount userAccount) {
		UserAccountDto userAccountDto = new UserAccountDto();
		userAccountDto.setUserName(userAccount.getUserName());
		userAccountDto.setUserPassword(userAccount.getUserPassword());
		userAccountDto.setLogin(userAccount.isLogin());
		userAccountDto.setLoginTime(userAccount.getLoginTime());
		return userAccountDto;
	}

}
