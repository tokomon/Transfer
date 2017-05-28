package com.example.repository;

import org.springframework.stereotype.Component;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.example.domain.Transfer;

@Component
public  interface TransferRepository extends CrudRepository<Transfer, Long>  {
	@Query("SELECT a FROM Transfer a")
	Collection<Transfer> findAll();

}
/*
 * public interface TransferRepository extends CrudRepository<Transfer, Long> {

	@Query("SELECT a FROM Transfer a WHERE a.numeroOperacion = ?1")
	Transfer findByNumero(Long numeroOperacion);

	// select a.* from account a
	@Query("SELECT a FROM Transfer a")
	Collection<Transfer> findAll();
}*/
 