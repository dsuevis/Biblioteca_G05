package com.unab.biblioteca.Repositories.CrudRepository;

import org.springframework.data.repository.CrudRepository;
import com.unab.biblioteca.Models.Employee;

public interface EmployeeCrudRepository extends CrudRepository <Employee, Integer>{
    
}
