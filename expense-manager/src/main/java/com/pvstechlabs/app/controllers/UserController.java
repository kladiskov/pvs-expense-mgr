package com.pvstechlabs.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pvstechlabs.app.data.entities.ExpenseRecord;
import com.pvstechlabs.app.data.service.ExpenseService;
import com.pvstechlabs.app.data.service.PayeeService;
import com.pvstechlabs.app.data.service.TypeService;

@Controller
@RequestMapping(value = "/expense")
public class UserController {

	@Autowired
	private ExpenseService expenseService;

	@Autowired
	private TypeService typeService;

	@Autowired
	private PayeeService payeeService;

	@RequestMapping(value = { "/", "" })
	public String goHome(Model model) {
		List<ExpenseRecord> expenses = expenseService.findAllByOrderByDate();
		model.addAttribute("expenses", expenses);
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
	public String saveExpense(@Valid @ModelAttribute ExpenseRecord record, Errors errors) {
		if (errors.hasErrors()) {
			return "expense_add";
		}
		expenseService.save(record);
		return "redirect:/expense";
	}

	@RequestMapping(value = "/view")
	public String viewExpenses(Model model) {
		List<ExpenseRecord> expenses = expenseService.findAllByOrderByDate();
		model.addAttribute("expenses", expenses);
		return "expenses_view";
	}

	@RequestMapping(value = "/{expenseId}")
	public String viewExpense(Model model, @PathVariable Long expenseId) {
		ExpenseRecord expense = expenseService.findOne(expenseId);
		model.addAttribute("expense", expense);
		return "expense_view";
	}

	@RequestMapping(value = "/edit={expenseId}")
	public String editExpense(Model model, @PathVariable Long expenseId) {
		ExpenseRecord expense = expenseService.findOne(expenseId);
		model.addAttribute("expense", expense);
		return "expense_edit";
	}

	@RequestMapping(value = "/delete={expenseId}")
	public String deleteExpense(Model model, @PathVariable Long expenseId) {
		if (expenseId != 0) {
			System.out.println("expenseId: " + expenseId);
			expenseService.delete(expenseId);
		}
		List<ExpenseRecord> expenses = expenseService.findAllByOrderByDate();
		model.addAttribute("expenses", expenses);
		return "expenses_view";
	}

}
