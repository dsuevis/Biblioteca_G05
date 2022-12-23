package com.unab.biblioteca.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.biblioteca.Models.Author;
import com.unab.biblioteca.Repositories.AuthorRepository;

@Service
public class AuthorService {

    @Autowired 
    private AuthorRepository authorRepository;

    // Traer todos los autores
    public List<Author> getAllAuthor() {
        return authorRepository.getAll();
    }

    // Traer una por id
    public Optional<Author> getAuthor(int idAuthor) {
        return authorRepository.getAuthor(idAuthor);
    }

    // Guardar
    public Author insertAuthor(Author author) {
        if (author.getIdAuthor() == null)
            // Campos obligatorios
            if (author.getName() != null && author.getLastname() != null && author.getNationality() != null)
                return authorRepository.save(author);
            else
                return author;
        else
            return author;
    }

    // Actualizar
    public Author updateAuthor(Author author) {
        if (author.getIdAuthor() != null) {
            // verificación de que el id exista en base de datos
            Optional<Author> temp = authorRepository.getAuthor(author.getIdAuthor());
            if (!temp.isEmpty()) {
                if (author.getName() != null)
                    temp.get().setName(author.getName());
                if (author.getLastname() != null)
                    temp.get().setLastname(author.getLastname());
                if (author.getNationality() != null)
                    temp.get().setNationality(author.getNationality());
                return authorRepository.save(temp.get());
            } else
                return author;
        } else
            return author;
    }

    // Eliminar
    public boolean deleteAuthor(int IdAuthor) {
        Boolean success = getAuthor(IdAuthor).map(author -> {
            authorRepository.delete(author);
            return true;
        }).orElse(false);
        return success;
    }


    
}
