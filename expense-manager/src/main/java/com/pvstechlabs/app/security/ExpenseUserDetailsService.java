package com.pvstechlabs.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.pvstechlabs.app.data.service.CredentialService;

@Component("expenseUserDetailsService")
public class ExpenseUserDetailsService implements UserDetailsService {

	@Autowired
	private CredentialService credentialService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return credentialService.findByUserName(username);
	}

}
