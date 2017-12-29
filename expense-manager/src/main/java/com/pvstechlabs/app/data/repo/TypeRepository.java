package com.pvstechlabs.app.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pvstechlabs.app.data.entities.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

}
