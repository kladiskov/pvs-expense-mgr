package com.pvstechlabs.app.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pvstechlabs.app.data.entities.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Long> {

}
