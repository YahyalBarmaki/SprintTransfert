package com.transfertArg.transfertArg.repository;

import com.transfertArg.transfertArg.model.Retrait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RetraitRepository extends JpaRepository<Retrait, Integer> {

}