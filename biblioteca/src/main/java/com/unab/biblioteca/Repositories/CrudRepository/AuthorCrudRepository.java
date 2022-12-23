package com.unab.biblioteca.Repositories.CrudRepository;

import org.springframework.data.repository.CrudRepository;
import com.unab.biblioteca.Models.Author;

public interface AuthorCrudRepository extends CrudRepository <Author, Integer> {
    
}
