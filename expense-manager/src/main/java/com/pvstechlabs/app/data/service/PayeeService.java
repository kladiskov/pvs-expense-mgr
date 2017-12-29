package com.pvstechlabs.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvstechlabs.app.data.entities.Payee;
import com.pvstechlabs.app.data.repo.PayeeRepository;

@Service
public class PayeeService {

	@Autowired
	private PayeeRepository repo;

	public void save(Payee payee) {
		repo.save(payee);
	}

	public void delete(Long payeeId) {
		repo.delete(payeeId);
	}

	public Payee findOne(Long payeeId) {
		return repo.findOne(payeeId);
	}

	public List<Payee> findAll() {
		return repo.findAll();
	}

}
