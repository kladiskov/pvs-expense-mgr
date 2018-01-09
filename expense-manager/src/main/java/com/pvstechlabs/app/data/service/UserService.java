package com.pvstechlabs.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvstechlabs.app.data.entities.ExpenseUser;
import com.pvstechlabs.app.data.repo.ExpenseUserRepository;

@Service
public class UserService {

	@Autowired
	private ExpenseUserRepository repo;

	public void save(ExpenseUser expenseUser) {
		repo.save(expenseUser);
	}

	public void delete(Long userId) {
		repo.delete(userId);
	}

	public ExpenseUser findOne(Long userId) {
		return repo.findOne(userId);
	}

	public List<ExpenseUser> findAll() {
		return repo.findAll();
	}

}
