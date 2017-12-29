package com.pvstechlabs.app.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pvstechlabs.app.data.entities.Payee;
import com.pvstechlabs.app.data.entities.Type;
import com.pvstechlabs.app.data.entities.User;
import com.pvstechlabs.app.data.service.PayeeService;
import com.pvstechlabs.app.data.service.TypeService;
import com.pvstechlabs.app.data.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private TypeService typeService;

	@Autowired
	private PayeeService payeeService;

	@RequestMapping(value = { "/", "" })
	public String goHome(Model model) {
		return "admin_home";
	}

	@RequestMapping(value = "/addType", method = RequestMethod.GET)
	public String addType(Model model) {
		Type type = new Type();
		model.addAttribute("type", type);
		return "add_type";
	}

	@RequestMapping(value = "/addType", method = RequestMethod.POST)
	public String saveType(@ModelAttribute Type type) {
		System.out.println("subytypes: " + type.getSubtypes().size());
		typeService.save(type);
		return "admin_home";
	}

	@RequestMapping("/viewTypes")
	public String viewTypes(Model model) {
		model.addAttribute("types", typeService.findAll());
		return "view_types";
	}

	@RequestMapping("/type/delete={typeId}")
	public String deleteType(@PathVariable Long typeId) {
		typeService.delete(typeId);
		return "redirect:/admin/viewTypes";
	}

	@RequestMapping(value = "/addPayee", method = RequestMethod.GET)
	public String addPayee(Model model) {
		Payee payee = new Payee();
		model.addAttribute("payee", payee);
		return "add_payee";
	}

	@RequestMapping(value = "/addPayee", method = RequestMethod.POST)
	public String savePayee(@ModelAttribute Payee payee) {
		payeeService.save(payee);
		return "admin_home";
	}

	@RequestMapping("/viewPayees")
	public String viewPayees(Model model) {
		model.addAttribute("payees", payeeService.findAll());
		return "view_payees";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "add_user";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user) {
		userService.save(user);
		return "redirect:/admin/viewUsers";
	}

	@RequestMapping("/viewUsers")
	public String viewUsers(Model model) {
		model.addAttribute("users", userService.findAll());
		userService.findAll().stream().forEach(System.out::println);
		return "view_users";
	}

	@RequestMapping("/user/delete={userId}")
	public String deleteUser(@PathVariable("userId") Long userId) {
		userService.delete(userId);
		return "redirect:/admin/viewUsers";
	}

	@RequestMapping("/user/edit={userId}")
	public String updateUser(Model model, @PathVariable("userId") Long userId) {
		model.addAttribute("user", userService.findOne(userId));
		model.addAttribute("userId", userId);
		return "add_user";
	}

}
