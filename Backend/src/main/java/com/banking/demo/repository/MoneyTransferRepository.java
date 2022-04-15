package com.banking.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.demo.entities.MoneyTransfer;

@Repository
public interface MoneyTransferRepository extends JpaRepository<MoneyTransfer, Long>{

	@Query("SELECT a FROM MoneyTransfer a WHERE a.accountNumber = ?1")
	List<MoneyTransfer> fetchTransAccount(String accountNumber);

}
