package com.unab.biblioteca.Models;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "loanReturns")
public class LoanReturns implements Serializable {
    // Attributes
    @Id
    private Integer idPestamos;
    private String loanDate;
    private String returnDate;
    private String status = "created";

    // Make main definition for n to n relation between LoanReturns and book
    @ManyToMany(mappedBy = "LoanReturnss")
    private Set<Book> books;

    // Make relation using foreign key into client
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties("LoanReturnss")
    private Client clientFK;

    // Make relation using foreign key into employee
    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    @JsonIgnoreProperties("LoanReturnss")
    private Employee employeeFK;

    // ============ Getters and Setters ============ //
    /**
     * This method returns the idPestamos
     * 
     * @return idPestamos
     */
    public Integer getIdPestamos() {
        return idPestamos;
    }

    /**
     * This method returns the book LoanDate
     * 
     * @return book LoanDate
     */
    public String getLoanDate() {
        return loanDate;
    }

    /**
     * This method sets a new value for the book LoanDate
     * 
     * @param loanDate
     */
    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    /**
     * This method returns the book returnDate
     * 
     * @return book returnDate
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * This method sets a new value for the book returnDate
     * 
     * @param returnDate
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * This method returns the book status
     * 
     * @return book status
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method sets a new value for the book status
     * 
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method returns the books associated to the LoanReturns
     * 
     * @return LoanReturn books
     */
    public Set<Book> getBooks() {
        return books;
    }

    /**
     * This method sets a new value for the LoanReturns books
     * 
     * @param books
     */
    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    /**
     * This method returns the book client
     * 
     * @return book client
     */
    public Client getClientFK() {
        return clientFK;
    }

    /**
     * This method sets a new value for the book client
     * 
     * @param employeeFK
     */
    public void setClientFK(Client clientFK) {
        this.clientFK = clientFK;
    }

    /**
     * This method returns the book employee
     * 
     * @return book employee
     */
    public Employee getEmployeeFK() {
        return employeeFK;
    }

    /**
     * This method sets a new value for the book employeeFK
     * 
     * @param employeeFK
     */
    public void setEmployeeFK(Employee employeeFK) {
        this.employeeFK = employeeFK;
    }
}
