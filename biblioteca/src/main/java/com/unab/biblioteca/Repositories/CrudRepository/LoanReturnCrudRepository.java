package com.unab.biblioteca.Repositories.CrudRepository;

import org.springframework.data.repository.CrudRepository;
import com.unab.biblioteca.Models.LoanReturns;

public interface LoanReturnCrudRepository extends CrudRepository <LoanReturns, Integer> {
    
}
