package com.pvstechlabs.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.pvstechlabs.app.data.entities.Credential;
import com.pvstechlabs.app.data.repo.CredentialRepository;

@Component("expenseUserDetailsService")
public class ExpenseUserDetailsService implements UserDetailsService {

	@Autowired
	private CredentialRepository credentialRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credential credential = credentialRepository.findByUserName(username);
		return new User(credential.getUserName(), credential.getPassword(),
				AuthorityUtils.createAuthorityList(credential.getRole()));
	}

}
