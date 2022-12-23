package com.unab.biblioteca.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.biblioteca.Models.Book;
import com.unab.biblioteca.Repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Traer todos los libros
    public List<Book> getAllBook() {
        return bookRepository.getAll();
    }

    // Traer una por id
    public Optional<Book> getBook(int isbn) {
        return bookRepository.getBook(isbn);
    }

    // Guardar
    public Book insertBook(Book book) {
        if (book.getIsbn() == null)
            // Campos obligatorios
            if (book.getTitle() != null && book.getType() != null && book.getLocation() != null)
                return bookRepository.save(book);
            else
                return book;
        else
            return book;
    }

    // Actualizar
    public Book updateBook(Book book) {
        if (book.getIsbn() != null) {
            // verificación de que el id exista en base de datos
            Optional<Book> temp = bookRepository.getBook(book.getIsbn());
            if (!temp.isEmpty()) {
                if (book.getTitle() != null)
                    temp.get().setTitle(book.getTitle());
                if (book.getType() != null)
                    temp.get().setType(book.getType());
                if (book.getEditorial() != null)
                    temp.get().setEditorial(book.getEditorial());
                if (book.getnEjemplares() != null)
                    temp.get().setnEjemplares(book.getnEjemplares());
                if (book.getLocation() != null)
                    temp.get().setLocation(book.getLocation());
                return bookRepository.save(temp.get());
            } else
                return book;
        } else
            return book;
    }

    // Eliminar
    public boolean deleteBook(int Isbn) {
        Boolean success = getBook(Isbn).map(book -> {
            bookRepository.delete(book);
            return true;
        }).orElse(false);
        return success;
    }

}
