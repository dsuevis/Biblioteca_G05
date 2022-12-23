package com.unab.biblioteca.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.biblioteca.Models.Employee;
import com.unab.biblioteca.Repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired 
    private EmployeeRepository employeeRepository;
    
    //Traer todos los empleados
   public List<Employee> getAllEmployee(){
    return employeeRepository.getAll();
   }

    //Traer una por id
    public Optional<Employee> getEmployee(int idEmpleado){
        return employeeRepository.getEmployee(idEmpleado);
    }

    // Guardar
    public Employee insertEmployee(Employee employee) {
        if (employee.getIdEmpleado() == null)
            // Campos obligatorios
            if (employee.getEmployeename() != null && employee.getEmployeelastname() != null && employee.getPassword() != null&& employee.getEmployeEmail() != null)
                return employeeRepository.save(employee);
            else
                return employee;
        else
            return employee;
    }

    // Actualizar
    public Employee updateEmployee (Employee employee) {
        if (employee.getIdEmpleado() != null) {
            // verificación de que el id exista en base de datos
            Optional<Employee> temp = employeeRepository.getEmployee(employee.getIdEmpleado());
            if (!temp.isEmpty()) {
                if (employee.getEmployeename() != null)
                    temp.get().setEmployeename(employee.getEmployeename());
                if (employee.getEmployeelastname() != null)
                    temp.get().setEmployeelastname(employee.getEmployeelastname());
                if (employee.getPassword() != null)
                    temp.get().setPassword(employee.getPassword());
                if (employee.getEmployeEmail() != null)
                    temp.get().setEmployeEmail(employee.getEmployeEmail());
                if (employee.getRol() != null)
                    temp.get().setRol(employee.getRol());
                return employeeRepository.save(temp.get());
            } else
                return employee;
        } else
            return employee;
    }

    // Eliminar
    public boolean deleteEmployee (int IdEmpleado) {
        Boolean success = getEmployee(IdEmpleado).map(employee -> {
            employeeRepository.delete(employee);
            return true;
    }).orElse(false);
        return success;
}
    
}
