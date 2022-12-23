package com.unab.biblioteca.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unab.biblioteca.Models.LoanReturns;
import com.unab.biblioteca.Repositories.CrudRepository.LoanReturnCrudRepository;

@Repository
public class LoanReturnRepository {
    @Autowired
    private LoanReturnCrudRepository loanReturnCrudRepository;

    //Función para traer todos los prestamos
    public List<LoanReturns> getAll(){
        return (List<LoanReturns>) loanReturnCrudRepository.findAll();     
    }

    //Función para buscar por código
    public Optional<LoanReturns> getLoanReturn (int idPrestamos){
        return loanReturnCrudRepository.findById(idPrestamos);
    }
    //Función para guardar 
    public LoanReturns save(LoanReturns loanReturn){
        return loanReturnCrudRepository.save(loanReturn);
    }

    //Función para eliminar
    public void delete(LoanReturns loanReturn){
        loanReturnCrudRepository.delete(loanReturn);
    }

    
}
