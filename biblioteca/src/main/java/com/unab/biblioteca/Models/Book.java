package com.unab.biblioteca.Models;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;


@Entity
@Table(name="book")
public class Book implements Serializable {
    //Attributes
    @Id
    private Integer isbn;
    private String title;
    private  String type;
    private  String editorial;
    private Integer nEjemplares;
    private  String location;

    //Make relation using foreign key into book
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties("books")
    private Author AuthorFK;

    //Make main definition for n to n relation between book and LoanReturns
    @ManyToMany
    @JoinTable(
    name = "book_LoanReturns",
    joinColumns = @JoinColumn(name="isbn"), // Book PK
    inverseJoinColumns = @JoinColumn(name="idPrestamos")) // LoanReturns PK
    private Set<LoanReturns> LoanReturnss;

    

    // ============ Getters and Setters ============ //
    /**
     * This method returns the book isbn
     * @return book isbn
     */
    public Integer getIsbn() {
        return isbn;
    }

    /**
     * This method returns the book title
     * @return book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method sets a new value for the book title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method returns the book register date
     * @return book type
     */
    public String gettype() {
        return type;
    }

    /**
     * This method sets a new value for the book register date
     * @param registerDate
     */
    public void settype (String type) {
        this.type = type;
    }

      /**
     * This method returns the book editorial
     * @return book editorial
     */
    public String geteditorial() {
        return editorial;
    }

    /**
     * This method sets a new value for the book editorial
     * @param editorial
     */
    public void seteditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * This method returns the book nEjemplares
     * @return book nEjemplares
     */
    public Integer getnEjemplares() {
        return nEjemplares;
    }

    /**
     * This method sets a new value for the book nEjemplares
     * @param nEjemplares
     */
    public void setnEjemplares(Integer nEjemplares) {
        this.nEjemplares = nEjemplares;
    }

    /**
     * This method returns the book Location
     * @return book Location
     */
    public String getlocation() {
        return location;
    }

    /**
     * This method sets a new value for the book location
     * @param location
     */
    public void setlocation(String location) {
        this.location = location;
    }

    /**
     * This method returns the book Author
     * @return book Author
     */
    public Author getAuthorFK() {
        return AuthorFK;
    }

    /**
     * This method sets a new value for the book Author
     * @param AuthorFK
     */
    public void setAuthorFK(Author AuthorFK) {
        this.AuthorFK = AuthorFK;
    }

    /**
     * This method returns the book LoanReturns
     * @return book LoanReturns
     */
    public Set<LoanReturns> getLoanReturnss() {
        return LoanReturnss;
    }

    /**
     * This method sets a new value for the book LoanReturns
     * @param authors
     */
    public void setLoanReturnss(Set<LoanReturns> LoanReturnss) {
        this.LoanReturnss = LoanReturnss;
    }
    

    
}
