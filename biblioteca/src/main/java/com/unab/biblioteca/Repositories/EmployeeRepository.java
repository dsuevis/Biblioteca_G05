package com.unab.biblioteca.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unab.biblioteca.Models.Employee;
import com.unab.biblioteca.Repositories.CrudRepository.EmployeeCrudRepository;

@Repository
public class EmployeeRepository {

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    //Función para traer todos los empleados
    public List<Employee> getAll(){
        return (List<Employee>) employeeCrudRepository.findAll();     
    }

    //Función para buscar por código
    public Optional<Employee> getEmployee (int idEmpleado){
        return employeeCrudRepository.findById(idEmpleado);
    }
    //Función para guardar 
    public Employee save(Employee employee){
        return employeeCrudRepository.save(employee);
    }

    //Función para eliminar
    public void delete(Employee employee){
        employeeCrudRepository.delete(employee);
    }
    
}
