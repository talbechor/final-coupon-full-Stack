package com.jb.couponsprojectteam.repositories;

import com.jb.couponsprojectteam.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmailAndPassword(String email, String password);
}
