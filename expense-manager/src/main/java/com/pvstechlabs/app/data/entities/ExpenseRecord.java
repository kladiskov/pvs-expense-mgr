package com.pvstechlabs.app.data.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EXPENSE_RECORD")
public class ExpenseRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EXPENSE_ID")
	private long expenseId;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "TYPE_ID")
	private Type type;

	@Column(name = "SUB_TYPE")
	private String subType;

	@Column(name = "EXPENSE_TITLE")
	private String title;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "PAYEE_ID")
	private Payee payee;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "USER_ID")
	private ExpenseUser expenseUser;

	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@Column(name = "DATE", columnDefinition = "DATETIME")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "DESCRIPTION")
	private String description;

	public long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(long expenseId) {
		this.expenseId = expenseId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Payee getPayee() {
		return payee;
	}

	public void setPayee(Payee payee) {
		this.payee = payee;
	}

	public ExpenseUser getUser() {
		return expenseUser;
	}

	public void setUser(ExpenseUser expenseUser) {
		this.expenseUser = expenseUser;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ExpenseRecord [expenseId=" + expenseId + ", type=" + type + ", subType=" + subType + ", title=" + title
				+ ", payee=" + payee + ", expenseUser=" + expenseUser + ", amount=" + amount + ", date=" + date + ", description="
				+ description + "]";
	}
}
