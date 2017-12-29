package com.pvstechlabs.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvstechlabs.app.data.entities.User;
import com.pvstechlabs.app.data.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public void save(User user) {
		repo.save(user);
	}

	public void delete(Long userId) {
		repo.delete(userId);
	}

	public User findOne(Long userId) {
		return repo.findOne(userId);
	}

	public List<User> findAll() {
		return repo.findAll();
	}

}
