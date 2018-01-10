package com.pvstechlabs.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.pvstechlabs.app.data.entities.Credential;
import com.pvstechlabs.app.data.repo.CredentialRepository;

/**
 * Custom implementation of authentication that can support various
 * authentication mechanisms.
 *
 */
@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CredentialRepository repo;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		Credential credential = repo.findByUserName(token.getName());
		if (!credential.getPassword().equals(token.getCredentials().toString())) {
			throw new BadCredentialsException("The credentials are invalid.");
		}
		return new UsernamePasswordAuthenticationToken(credential, credential.getPassword(),
				credential.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
