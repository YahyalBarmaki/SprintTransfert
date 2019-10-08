package com.transfertArg.transfertArg.repository;

import com.transfertArg.transfertArg.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Integer> {

}