package com.pvstechlabs.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvstechlabs.app.data.entities.ExpenseRecord;
import com.pvstechlabs.app.data.repo.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository repo;

	public void save(ExpenseRecord record) {
		repo.save(record);
	}

	public void delete(Long expenseId) {
		repo.delete(expenseId);
	}

	public ExpenseRecord findOne(Long expenseId) {
		return repo.findOne(expenseId);
	}

	public List<ExpenseRecord> findAll() {
		return repo.findAll();
	}

	public List<ExpenseRecord> findAllByOrderByDate() {
		return repo.findAllByOrderByDate();
	}

}
