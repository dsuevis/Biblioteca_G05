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

import com.unab.biblioteca.Models.Author;
import com.unab.biblioteca.Services.AuthorService;

@RestController 
@RequestMapping ("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    //Traer todos los autores
    @GetMapping("/all")
    public List<Author> getAllAuthor(){
     return authorService.getAllAuthor();
   }

    //Traer una por id
    @GetMapping("/{id}")
    public Optional<Author> getAuthor(@PathVariable("id") int idAuthor){
        return authorService.getAuthor(idAuthor);
    }

    //Guardar
    @PostMapping ("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Author insertAuthor(@RequestBody Author author){
            return authorService.insertAuthor(author);
        }

    //Actualizar
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Author updateAuthor (@RequestBody Author  author) {
        return authorService.updateAuthor(author);
    }

    //Eliminar
    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAuthor(@PathVariable ("id") int IdAuthor){
        return authorService.deleteAuthor(IdAuthor);
    }
    
}
