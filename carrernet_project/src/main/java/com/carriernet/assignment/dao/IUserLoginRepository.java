package com.carriernet.assignment.dao;

import java.sql.Timestamp;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carriernet.assignment.model.UserAccount;

@Repository("iUserLoginRepository")
//@Transactional("txManager")
public interface IUserLoginRepository extends JpaRepository<UserAccount, UserAccount> {

	@SuppressWarnings("unchecked")
	@Transactional
	public UserAccount save(UserAccount UserAccount) throws PersistenceException;;

	@Transactional
	public UserAccount findByUserNameAndUserPassword(String userName, String userPassword) throws PersistenceException;

	@Transactional
	public UserAccount findById(Integer id) throws PersistenceException;;

	@Transactional
	@Modifying
	@Query("UPDATE UserAccount ua SET ua.userPassword = :userPassword WHERE ua.userName = :userName")
	public Integer updatePassword(@Param("userName") String userName, @Param("userPassword") String userPassword)
			throws PersistenceException;;

	@Transactional
	@Modifying
	@Query("UPDATE UserAccount ua SET ua.login = :login, ua.loginTime = :loginTime  WHERE ua.id = :id")
	public Integer updateLoginUser(@Param("loginTime") Timestamp loginTime, @Param("login") boolean login,
			@Param("id") Integer id) throws PersistenceException;

	@Transactional
	@Modifying
	@Query("UPDATE UserAccount ua SET ua.login = :login, ua.loginTime = :loginTime  WHERE ua.id = :id")
	public Integer logout(@Param("loginTime") Timestamp loginTime, @Param("login") boolean login,
			@Param("id") Integer id) throws PersistenceException;

}
