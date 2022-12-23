package com.unab.biblioteca.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.biblioteca.Models.LoanReturns;
import com.unab.biblioteca.Repositories.LoanReturnRepository;

@Service
public class LoanReturnService {

    @Autowired 
    private LoanReturnRepository loanReturnRepository;

    //Traer todos los prestamos
   public List<LoanReturns> getAllLoanReturn(){
    return loanReturnRepository.getAll();
   }

    //Traer una por id
    public Optional<LoanReturns> getLoanReturn(int idPrestamos){
        return loanReturnRepository.getLoanReturn(idPrestamos);
    }

    // Guardar
    public LoanReturns insertLoanReturn(LoanReturns loanReturn) {
        if (loanReturn.getEmployeeFK() == null)
            // Campos obligatorios
            if (loanReturn.getLoanDate() != null && loanReturn.getReturnDate() != null)
                return loanReturnRepository.save(loanReturn);
            else
                return loanReturn;
        else
            return loanReturn;
    }

    // Actualizar
    public LoanReturns updateLoanReturn (LoanReturns loanReturn) {
        if (loanReturn.getIdPestamos() != null) {
            // verificación de que el id exista en base de datos
            Optional<LoanReturns> temp = loanReturnRepository.getLoanReturn(loanReturn.getIdPestamos());
            if (!temp.isEmpty()) {
                if (loanReturn.getLoanDate() != null)
                    temp.get().setLoanDate(loanReturn.getLoanDate());
                if (loanReturn.getReturnDate() != null)
                    temp.get().setReturnDate(loanReturn.getReturnDate());
                if (loanReturn.getStatus() != null)
                    temp.get().setStatus(loanReturn.getStatus());
                return loanReturnRepository.save(temp.get());
            } else
                return loanReturn;
        } else
            return loanReturn;
    }

    // Eliminar
    public boolean deleteLoanReturn(int IdPrestamos) {
        Boolean success = getLoanReturn(IdPrestamos).map(loanReturn -> {
            loanReturnRepository.delete(loanReturn);
            return true;
        }).orElse(false);
        return success;
    
}
}
