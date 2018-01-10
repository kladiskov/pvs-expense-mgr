package com.pvstechlabs.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pvstechlabs.app.data.entities.Credential;
import com.pvstechlabs.app.data.entities.ExpenseUser;
import com.pvstechlabs.app.data.service.CredentialService;

@Controller
@RequestMapping(value = "/")
public class LoginController {

	@Autowired
	private CredentialService credentialService;

	@RequestMapping(value = "")
	public String redirectHome(Model model) {
		return "redirect:/home";
	}

	@RequestMapping(value = { "/home", "/home/" })
	public String goHome(Model model) {
		return "expense_home";
	}

	@RequestMapping(value = "/login/newuser", method = RequestMethod.GET)
	public String signUp(Model model) {
		model.addAttribute("user", new ExpenseUser());
		return "signup";
	}

	@RequestMapping(value = "/login/newuser", method = RequestMethod.POST)
	public String finishSignUp(Model model, @ModelAttribute ExpenseUser expenseUser) {
		Credential credential = expenseUser.getCredential();
		credential.setExpenseUser(expenseUser);
		credential.setRole("ROLE_USER");
		credentialService.save(credential);
		Authentication authentication = new UsernamePasswordAuthenticationToken(credential, credential.getPassword(),
				credential.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "redirect:/home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String signInRequest(Model model) {
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
