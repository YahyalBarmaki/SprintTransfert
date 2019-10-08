package com.transfertArg.transfertArg.repository;

import com.transfertArg.transfertArg.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}