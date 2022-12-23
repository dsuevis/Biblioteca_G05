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

import com.unab.biblioteca.Models.LoanReturns;
import com.unab.biblioteca.Services.LoanReturnService;

@RestController 
@RequestMapping ("/loanReturns")
public class LoanReturnsController {
    @Autowired
    private LoanReturnService loanReturnService;

    //Traer todos los clientes
    @GetMapping("/all")
    public List<LoanReturns> getAllLoanReturn(){
     return loanReturnService.getAllLoanReturn();
   }

    //Traer una por id
    @GetMapping("/{id}")
    public Optional<LoanReturns> getLoanReturn(@PathVariable("id") int idPrestamos){
        return loanReturnService.getLoanReturn(idPrestamos);
    }

    //Guardar
    @PostMapping ("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public LoanReturns insertLoanReturn (@RequestBody LoanReturns loanReturn){
            return loanReturnService.insertLoanReturn(loanReturn);
        }

    //Actualizar
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public LoanReturns updateLoanReturn (@RequestBody LoanReturns LoanReturn) {
        return loanReturnService.updateLoanReturn(LoanReturn);
    }

    //Eliminar
    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteLoanReturn (@PathVariable ("id") int idPrestamos){
        return loanReturnService.deleteLoanReturn(idPrestamos);
    }
    
}
