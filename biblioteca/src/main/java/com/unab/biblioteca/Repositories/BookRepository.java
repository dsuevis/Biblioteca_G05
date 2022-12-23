package com.unab.biblioteca.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unab.biblioteca.Models.Book;
import com.unab.biblioteca.Repositories.CrudRepository.BookCrudRepository;

@Repository
public class BookRepository {
    @Autowired
    private BookCrudRepository bookCrudRepository;

    //Función para traer todos los libros
    public List<Book> getAll(){
        return (List<Book>) bookCrudRepository.findAll();     
    }

    //Función para buscar por código
    public Optional<Book> getBook (int isbn){
        return bookCrudRepository.findById(isbn);
    }
    //Función para guardar 
    public Book save(Book book){
        return bookCrudRepository.save(book);
    }

    //Función para eliminar
    public void delete(Book book){
        bookCrudRepository.delete(book);
    }

    
}
