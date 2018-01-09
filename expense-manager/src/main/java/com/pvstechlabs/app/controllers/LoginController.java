package com.pvstechlabs.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pvstechlabs.app.data.entities.Credential;
import com.pvstechlabs.app.data.entities.ExpenseUser;
import com.pvstechlabs.app.data.service.CredentialService;
import com.pvstechlabs.app.data.service.ExpenseService;
import com.pvstechlabs.app.data.service.UserService;

@Controller
@RequestMapping(value = "/")
public class LoginController {

	@Autowired
	private CredentialService credentialService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "")
	public String redirectHome(Model model) {
		return "redirect:/home";
	}

	@RequestMapping(value = { "/home", "/home/" })
	public String goHome(Model model) {
		return "expense_home";
	}

	@RequestMapping(value = "/login/newuser")
	public String signUpStepOne(Model model) {
		Credential credential = new Credential();
		model.addAttribute("credential", credential);
		return "signup1";
	}

	@RequestMapping(value = "/login/newuser", method = RequestMethod.POST)
	public String signUpStepTwo(Model model, @ModelAttribute Credential credential) {
		System.out.println("credential.getUserName(): " + credential.getUserName());
		ExpenseUser expenseUser = new ExpenseUser();
		expenseUser.setCredential(credential);
		System.out.println("ExpenseUser: " + expenseUser);
		System.out.println("credential:" + credential);
		model.addAttribute("user", expenseUser);
		return "signup2";
	}

	@RequestMapping(value = "/login/finishsignup", method = RequestMethod.POST)
	public String signUpFinish(Model model, @ModelAttribute ExpenseUser expenseUser) {
		System.out.println("ExpenseUser: " + expenseUser);
		userService.save(expenseUser);
		Credential credential = expenseUser.getCredential();
		credential.setExpenseUser(expenseUser);
		credentialService.save(credential);
		return "user_login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String signInRequest(Model model) {
		System.out.println("user_login");
		return "user_login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void signIn(Model model, @RequestParam("custom_username") String username,
			@RequestParam("custom_password") String password) {
		System.out.println("signin");
		System.out.println("username: " + username);
		System.out.println("password: " + password);
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String adminSignInRequest(Model model) {
		System.out.println("received request");
		return "user_login";
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public void adminSignIn(Model model, @RequestParam("custom_username") String username,
			@RequestParam("custom_password") String password) {
		System.out.println("admin login post");
	}

}
