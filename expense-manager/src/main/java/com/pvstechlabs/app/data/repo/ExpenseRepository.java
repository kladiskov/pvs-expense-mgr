package com.pvstechlabs.app.data.repo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pvstechlabs.app.data.entities.ExpenseRecord;
import com.pvstechlabs.app.data.entities.ExpenseUser;
import com.pvstechlabs.app.data.entities.Payee;
import com.pvstechlabs.app.data.entities.Type;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseRecord, Long> {

	public List<ExpenseRecord> findAllByexpenseUserOrderByDate(ExpenseUser expenseUser);

	public List<ExpenseRecord> findByExpenseUserAndDateBetweenOrderByDate(ExpenseUser expenseUser, Date startDate,
			Date endDate);

	public List<ExpenseRecord> findByExpenseUserAndTypeOrderByDate(ExpenseUser expenseUser, Type type);

	public List<ExpenseRecord> findByExpenseUserAndPayeeOrderByDate(ExpenseUser expenseUser, Payee payee);

	public List<ExpenseRecord> findByExpenseUserAndTitleContainingOrderByDate(ExpenseUser expenseUser, String title);

	public List<ExpenseRecord> findByExpenseUserAndAmountGreaterThan(ExpenseUser expenseUser, BigDecimal amount);

	public List<ExpenseRecord> findByExpenseUserAndTitleContainingOrTitleContainingOrderByDate(ExpenseUser expenseUser,
			String title1, String title2);

}
