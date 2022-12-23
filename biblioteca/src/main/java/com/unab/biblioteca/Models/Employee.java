package com.unab.biblioteca.Models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-generated id
    private Integer idEmpleado;
    private String employeename;
    private String employeelastname;
    private String password;
    private String employeEmail;
    private String rol;

    
    //Make inverse relation with LoanReturn table
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "employeeFK")
    @JsonIgnoreProperties("employeeFK")
    private List<LoanReturns> LoanReturnss;
    
     // ============ Getters and Setters ============ //
     /**
     * This method returns the Employee id
     * @return Employee id
     */
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

      /**
     * This method returns the client name
     * @return client name
     */
    public String getEmployeename() {
        return employeename;
    }

    /**
     * This method sets a new value for the employee name
     * @param name
     */
    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    /**
     * This method return the employee lastname
     * @return employee  lastname
     */
    public String getEmployeelastname() {
        return employeelastname;
    }

    /**
     * This method sets a new value for the employee  lastname
     * @param employeelastname
     */
    public void setEmployeelastname (String employeelastname) {
        this.employeelastname = employeelastname;
    }

    /**
     * This method return the  password
     * @return  password
     */
    public String getPassword () {
        return password;
    }

    /**
     * This method sets a new value for the password
     * @param password
     */
    public void setPassword (String password) {
        this.password = password;
    }
    
    /**
     * This method return the client email
     * @return  email
     */
    public String getEmployeEmail() {
        return employeEmail;
    }

    /**
     * This method sets a new value for the employeEmail
     * @param employeEmail
     */
    public void setEmployeEmail(String employeEmail) {
        this.employeEmail = employeEmail;
    }

    /**
     * This method return the Rol
     * @return Rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * This method sets a new value for the employee rol
     * @param rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
}
