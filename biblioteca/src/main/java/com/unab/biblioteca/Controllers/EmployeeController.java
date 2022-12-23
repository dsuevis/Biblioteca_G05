package com.unab.biblioteca.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unab.biblioteca.Models.Employee;
import com.unab.biblioteca.Services.EmployeeService;

@RestController 
@RequestMapping ("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Traer todos los clientes
    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
     return employeeService.getAllEmployee();
   }

    //Traer una por id
    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id") int idEmpleado){
        return employeeService.getEmployee(idEmpleado);
    }

    //Guardar
    @PostMapping ("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee insertEmployee (@RequestBody Employee employee){
            return employeeService.insertEmployee(employee);
        }

    //Actualizar
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee updateEmployee (@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    //Eliminar
    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteEmployee (@PathVariable ("id") int idEmpleado){
        return employeeService.deleteEmployee(idEmpleado);
    }
    
}
