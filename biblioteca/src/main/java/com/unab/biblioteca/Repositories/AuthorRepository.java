package com.unab.biblioteca.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unab.biblioteca.Models.Author;
import com.unab.biblioteca.Repositories.CrudRepository.AuthorCrudRepository;

@Repository
public class AuthorRepository {
    @Autowired
    private AuthorCrudRepository authorCrudRepository;

    //Función para traer todos los Autores
    public List<Author> getAll(){
        return (List<Author>) authorCrudRepository.findAll();     
    }

    //Función para buscar por código
    public Optional<Author> getBook (int idAuthor){
        return authorCrudRepository.findById(idAuthor);
    }
    //Función para guardar 
    public Author save(Author author){
        return authorCrudRepository.save(author);
    }

    //Función para eliminar
    public void delete(Author author){
        authorCrudRepository.delete(author);
    }
}
