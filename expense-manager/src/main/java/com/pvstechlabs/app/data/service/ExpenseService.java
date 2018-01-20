package com.pvstechlabs.app.data.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvstechlabs.app.data.entities.ExpenseRecord;
import com.pvstechlabs.app.data.entities.ExpenseUser;
import com.pvstechlabs.app.data.entities.Payee;
import com.pvstechlabs.app.data.entities.Type;
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

	public List<ExpenseRecord> findAllByexpenseUserOrderByDate(ExpenseUser user) {
		return repo.findAllByexpenseUserOrderByDate(user);
	}

	public List<ExpenseRecord> findByDateBetween(ExpenseUser user,Date startDate, Date endDate) {
		return repo.findByExpenseUserAndDateBetweenOrderByDate(user,startDate, endDate);
	}

	public List<ExpenseRecord> findByTypeOrderByDate(ExpenseUser user,Type type) {
		return repo.findByExpenseUserAndTypeOrderByDate(user, type);
	}

	public List<ExpenseRecord> findByPayeeOrderByDate(ExpenseUser user,Payee payee){
		return repo.findByExpenseUserAndPayeeOrderByDate(user,payee);
	}

}
