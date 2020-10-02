package com.carriernet.assignment.dao;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carriernet.assignment.model.UserWallet;

@Repository("iUserWalletRepository")
public interface IUserWalletRepository extends JpaRepository<UserWallet, Integer> {

	@SuppressWarnings("unchecked")
	@Transactional
	public UserWallet save(UserWallet userWallet) throws PersistenceException;;

	@Transactional
	public UserWallet findByAcno(String acno) throws PersistenceException;

	@Transactional
	public List<UserWallet> findAll() throws PersistenceException;
	
	@Transactional
	@Modifying
	@Query("UPDATE UserWallet uw SET uw.amount = :amount WHERE uw.acno = :acno")
	public Integer updateAcAmout(@Param("amount") double amount, @Param("acno") String acno) throws PersistenceException;

}
