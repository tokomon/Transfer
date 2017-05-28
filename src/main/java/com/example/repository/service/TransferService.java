package com.example.repository.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Account;
import com.example.domain.Transfer;
import com.example.repository.AccountRepository;
import com.example.repository.TransferRepository;

@Component
public class TransferService {

	@Autowired
	AccountRepository repository;
	
	Long c = (long) 0;
	@Autowired
	TransferRepository transferRepository;

	public void transfer(String cuentaOrigen, String cuentaDestino, double monto) throws Exception {
		Account source = repository.findByNumero(cuentaOrigen);
		Account target = repository.findByNumero(cuentaDestino);
		double saldo = source.getSaldo();
		if (saldo >= monto) {
			
			source.setSaldo(source.getSaldo() - monto);
			target.setSaldo(target.getSaldo() + monto);
			Transfer transfer = new Transfer();
			transfer.setNumeroOperacion(c);
			transfer.setOrigen(source);
			transfer.setDestino(target);
			transfer.setMonto(monto);
			transfer.setFecha(new Date());
			repository.save(source);
			repository.save(target);
			transferRepository.save(transfer);
			c++;
			
		} else {
			throw new Exception("Saldo insuficiente");
		}
	}
	
	
	
}
