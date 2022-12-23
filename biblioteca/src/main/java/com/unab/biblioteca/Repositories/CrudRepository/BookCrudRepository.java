package com.unab.biblioteca.Repositories.CrudRepository;

import org.springframework.data.repository.CrudRepository;
import com.unab.biblioteca.Models.Book;


public interface BookCrudRepository extends CrudRepository <Book, Integer> {
    
}
