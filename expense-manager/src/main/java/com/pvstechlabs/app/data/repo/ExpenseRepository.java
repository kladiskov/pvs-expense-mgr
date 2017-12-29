package com.pvstechlabs.app.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvstechlabs.app.data.entities.ExpenseRecord;

public interface ExpenseRepository extends JpaRepository<ExpenseRecord, Long> {
	
	public List<ExpenseRecord> findAllByOrderByDate();

}
