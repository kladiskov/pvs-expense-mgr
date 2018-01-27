package com.pvstechlabs.app.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pvstechlabs.app.data.entities.Credential;
import com.pvstechlabs.app.data.entities.ExpenseRecord;
import com.pvstechlabs.app.data.entities.ExpenseUser;
import com.pvstechlabs.app.data.entities.Payee;
import com.pvstechlabs.app.data.entities.Type;
import com.pvstechlabs.app.data.repo.ExpenseRepository;
import com.pvstechlabs.app.data.service.ExpenseService;
import com.pvstechlabs.app.data.service.PayeeService;
import com.pvstechlabs.app.data.service.TypeService;

@Controller
@RequestMapping(value = "/expense")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@Autowired
	private TypeService typeService;

	@Autowired
	private PayeeService payeeService;

	@RequestMapping(value = { "", "/" })
	public String goHome(Model model, Pageable pageable, Sort sort) {
		model.addAttribute("page", expenseService.findByExpenseUser(getLoggedInUser(), pageable));
		model.addAttribute("sort", (sort != null) ? sort.iterator().next().getProperty() : "");
		return "expense_home";
	}

	@RequestMapping(value = "/create")
	public String createExpense(Model model) {
		ExpenseRecord expense = new ExpenseRecord();
		model.addAttribute("expense", expense);
		model.addAttribute("types", typeService.findAll());
		model.addAttribute("payees", payeeService.findAll());
		return "expense_add";
	}

	@RequestMapping(value = "create/{typeId}")
	public String getSubTypes(Model model, @PathVariable Long typeId) {
		model.addAttribute("subTypes", typeService.findOne(typeId).getSubtypes());
		return "expense_subtype";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveExpense(Model model, @Valid @ModelAttribute ExpenseRecord record, Errors errors) {
		if (errors.hasErrors()) {
			return "expense_add";
		}
		record.setUser(getLoggedInUser());
		expenseService.save(record);
		model.addAttribute("expense", record);
		return "expense_view";
	}

	@RequestMapping(value = "/view")
	public String viewExpenses(Model model) {
		List<ExpenseRecord> expenses = expenseService.findAll(getLoggedInUser());
		List<Type> types = typeService.findAll();
		List<Payee> payees = payeeService.findAll();
		model.addAttribute("types", types);
		model.addAttribute("payees", payees);
		model.addAttribute("expenses", expenses);
		return "expenses_view";
	}

	@RequestMapping(value = "/view/filterByDate", method = RequestMethod.POST)
	public String filterByDate(Model model, @RequestParam("startDate") Date startDate,
			@RequestParam("endDate") Date endDate) {
		List<ExpenseRecord> expenses = expenseService.findByDateBetween(getLoggedInUser(), startDate, endDate);
		List<Type> types = typeService.findAll();
		List<Payee> payees = payeeService.findAll();
		model.addAttribute("types", types);
		model.addAttribute("payees", payees);
		model.addAttribute("expenses", expenses);
		return "expenses_view";
	}

	@RequestMapping(value = "/view/filterByType", method = RequestMethod.POST)
	public String filterByType(Model model, @RequestParam("type") Long typeId) {
		Type type = typeService.findOne(typeId);
		if (type == null) {
			return "expenses_view";
		}
		List<ExpenseRecord> expenses = expenseService.findByType(getLoggedInUser(), type);
		List<Type> types = typeService.findAll();
		List<Payee> payees = payeeService.findAll();
		model.addAttribute("types", types);
		model.addAttribute("payees", payees);
		model.addAttribute("expenses", expenses);
		return "expenses_view";
	}

	@RequestMapping(value = "/view/filterByPayee", method = RequestMethod.POST)
	public String filterByPayee(Model model, @RequestParam("payee") Long payeeId) {
		Payee payee = payeeService.findOne(payeeId);
		if (payee == null) {
			return "expenses_view";
		}
		List<ExpenseRecord> expenses = expenseService.findByPayee(getLoggedInUser(), payee);
		List<Type> types = typeService.findAll();
		List<Payee> payees = payeeService.findAll();
		model.addAttribute("types", types);
		model.addAttribute("payees", payees);
		model.addAttribute("expenses", expenses);
		return "expenses_view";
	}

	@RequestMapping(value = "/view/keyWordSearch", method = RequestMethod.POST)
	public String filterByKeyword(Model model, @RequestParam("title") String title) {
		System.out.println("title: " + title);
		List<ExpenseRecord> expenses = expenseService.findByTitle(getLoggedInUser(), title);
		List<Type> types = typeService.findAll();
		List<Payee> payees = payeeService.findAll();
		model.addAttribute("types", types);
		model.addAttribute("payees", payees);
		model.addAttribute("expenses", expenses);
		return "expenses_view";
	}

	@RequestMapping(value = "/{expenseId}")
	public String viewExpense(Model model, @PathVariable("expenseId") ExpenseRecord expense) {
		model.addAttribute("expense", expense);
		return "expense_view";
	}

	@RequestMapping(value = "/edit={expenseId}")
	public String editExpense(Model model, @PathVariable Long expenseId) {
		ExpenseRecord expense = expenseService.findOne(expenseId);
		List<Type> types = typeService.findAll();
		List<Payee> payees = payeeService.findAll();
		model.addAttribute("types", types);
		model.addAttribute("payees", payees);
		model.addAttribute("expense", expense);
		model.addAttribute("expenseId", expenseId);
		return "expense_edit";
	}

	@RequestMapping(value = "/delete={expenseId}")
	public String deleteExpense(Model model, @PathVariable Long expenseId) {
		if (expenseId != 0) {
			System.out.println("expenseId: " + expenseId);
			expenseService.delete(expenseId);
		}
		List<ExpenseRecord> expenses = expenseService.findAll(getLoggedInUser());
		List<Type> types = typeService.findAll();
		List<Payee> payees = payeeService.findAll();
		model.addAttribute("types", types);
		model.addAttribute("payees", payees);
		model.addAttribute("expenses", expenses);
		return "expenses_view";
	}

	@RequestMapping(value = "/update={expenseId}", method = RequestMethod.POST)
	public String updateExpense(Model model, @PathVariable Long expenseId, @ModelAttribute ExpenseRecord record) {
		System.out.println("updateExpense called");
		if (expenseId != 0) {
			System.out.println("record: " + record);
			record.setExpenseId(expenseId);
			expenseService.save(record);
		}
		List<ExpenseRecord> expenses = expenseService.findAll(getLoggedInUser());
		List<Type> types = typeService.findAll();
		List<Payee> payees = payeeService.findAll();
		model.addAttribute("types", types);
		model.addAttribute("payees", payees);
		model.addAttribute("expenses", expenses);
		return "expenses_view";
	}

	private ExpenseUser getLoggedInUser() {
		Credential credential = (Credential) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return credential.getExpenseUser();
	}

}
