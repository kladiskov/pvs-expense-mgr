package com.pvstechlabs.app.data.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvstechlabs.app.data.entities.ExpenseRecord;
import com.pvstechlabs.app.data.entities.Payee;
import com.pvstechlabs.app.data.entities.Type;

public interface ExpenseRepository extends JpaRepository<ExpenseRecord, Long> {

	public List<ExpenseRecord> findAllByOrderByDate();

	public List<ExpenseRecord> findByDateBetweenOrderByDate(Date startDate, Date endDate);

	public List<ExpenseRecord> findByTypeOrderByDate(Type type);

	public List<ExpenseRecord> findByPayeeOrderByDate(Payee payee);

}
