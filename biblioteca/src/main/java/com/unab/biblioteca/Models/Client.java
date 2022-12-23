package com.unab.biblioteca.Models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-generated id
    private Integer idClient;
    private String clientname;
    private String clientlastname;
    private String address;
    private String email;
    private Integer telephone;


    //Make inverse relation with LoanReturn table
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "clientFK")
    @JsonIgnoreProperties("clientFK")
    private List<LoanReturns> LoanReturnss;  
    
  // ============ Getters and Setters ============ //
     /**
     * This method returns the client id
     * @return client id
     */
    public Integer getIdClient() {
        return idClient;
    }

      /**
     * This method returns the client name
     * @return client name
     */
    public String getClientname() {
        return clientname;
    }

    /**
     * This method sets a new value for the author name
     * @param name
     */
    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    /**
     * This method return the client lastname
     * @return client  lastname
     */
    public String getClientlastname() {
        return clientlastname;
    }

    /**
     * This method sets a new value for the client  lastname
     * @param clientlastname
     */
    public void setClientlastname(String clientlastname) {
        this.clientlastname = clientlastname;
    }

    /**
     * This method return the client address
     * @return client  address
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method sets a new value for the client  address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * This method return the client email
     * @return client email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method sets a new value for the client email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

        /**
     * This method return the client telephone
     * @return client telephone
     */
    public Integer getTelephone() {
        return telephone;
    }

    /**
     * This method sets a new value for the client telephone
     * @param telephone
     */
    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }
}
