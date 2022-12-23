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

import com.unab.biblioteca.Models.Book;
import com.unab.biblioteca.Services.BookService;

@RestController 
@RequestMapping ("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    //Traer todos los libros
    @GetMapping("/all")
    public List<Book> getAllBook(){
     return bookService.getAllBook();
   }

    //Traer una por id
    @GetMapping("/{id}")
    public Optional<Book> getBook(@PathVariable("id") int isbn){
        return bookService.getBook(isbn);
    }

    //Guardar
    @PostMapping ("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Book insertBook (@RequestBody Book book){
            return bookService.insertBook(book);
        }

    //Actualizar
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Book updateBook (@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    //Eliminar
    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteBook(@PathVariable ("id") int isbn){
        return bookService.deleteBook(isbn);
    }
    
    
}
