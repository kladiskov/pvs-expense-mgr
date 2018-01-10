package com.pvstechlabs.app.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvstechlabs.app.data.entities.Credential;
import com.pvstechlabs.app.data.repo.CredentialRepository;

@Service
public class CredentialService {

	@Autowired
	private CredentialRepository repo;

	public void save(Credential credential) {
		repo.save(credential);
	}

	public void delete(Long credentialId) {
		repo.delete(credentialId);
	}

	public Credential findOne(Long credentialId) {
		return repo.findOne(credentialId);
	}
	
	public Credential findByUserName(String userName) {
		return repo.findByUserName(userName);
	}
	

}
