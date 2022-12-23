package com.unab.biblioteca.Models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author implements Serializable {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-generated id
    private Integer idAuthor;
    private String name;
    private String lastname;
    private String nationality;

    //Make inverse relation with book table
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "author")
    @JsonIgnoreProperties("author")
    private List<Book> books;

    // ============ Getters and Setters ============ //
    /**
     * This method returns the Author id
     * @return Author id
     */
    public Integer getIdAuthor() {
        return idAuthor;
    }

      /**
     * This method returns the author name
     * @return author name
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets a new value for the author name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method return the author lastname
     * @return author lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * This method sets a new value for the author lastname
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * This method return the author nationality
     * @return author nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * This method sets a new value for the author nationality
     * @param nationality
     */
    public void setNationality (String nationality) {
        this.nationality = nationality;
    }

    
}
