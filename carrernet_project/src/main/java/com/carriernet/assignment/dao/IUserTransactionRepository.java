package com.carriernet.assignment.dao;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carriernet.assignment.model.UserTransaction;


@Repository("iUserTransactionRepository")
//@Transactional("txManager")
public interface IUserTransactionRepository extends JpaRepository<UserTransaction, Integer> {

	@SuppressWarnings("unchecked")
	@Transactional
	public UserTransaction save(UserTransaction userTransaction) throws PersistenceException;;

	//@Transactional
	//public UserTransaction findByAcFromAndAcTo(String acFrom, String acTo) throws PersistenceException;
	
	@Transactional
	public List<UserTransaction> findByAcFrom(String acFrom) throws PersistenceException;;

	/*@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE UserAccount ua SET ua.userPassword =: userPassword WHERE ua.id = :id")
	public UserAccount update(@Param("id") Integer id, @Param("userPassword") String userPassword)
			throws PersistenceException;;
*/
}
