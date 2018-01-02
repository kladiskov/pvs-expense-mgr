package com.pvstechlabs.app.data.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;
import com.pvstechlabs.app.data.entities.ExpenseRecord;
import com.pvstechlabs.app.data.entities.SubType;
import com.pvstechlabs.app.data.entities.Type;
import com.pvstechlabs.app.data.repo.TypeRepository;

@Service
public class TypeService {

	@Autowired
	private TypeRepository repo;

	public void save(Type type) {
		repo.save(type);
	}

	public void delete(Long typeId) {
		repo.delete(typeId);
	}

	public Type findOne(Long typeId) {
		return repo.findOne(typeId);
	}

	public List<Type> findAll() {
		return repo.findAll();
	}

	public List<SubType> findAllSubCategory() {
		List<SubType> subTypes = new ArrayList<>();
		List<Type> types = repo.findAll();
		for (Type type : types) {
			for (SubType subType : type.getSubtypes())
				subTypes.add(subType);
		}
		return subTypes;
	}

}
