/**
 * 
 */
package com.pvstechlabs.app.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pvstechlabs.app.data.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
