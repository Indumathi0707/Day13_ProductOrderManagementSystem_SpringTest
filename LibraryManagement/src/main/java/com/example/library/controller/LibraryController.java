package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.entity.Category;
import com.example.library.entity.Reader;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.CategoryRepository;
import com.example.library.repository.ReaderRepository;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @PostMapping("/readers")
    public Reader addReader(@RequestBody Reader reader) {
        System.out.println("Adding Reader: " + reader.getName());
        return readerRepository.save(reader);
    }

    @GetMapping("/readers")
    public List<Reader> getAllReaders() {
        System.out.println("Fetching all readers...");
        return readerRepository.findAll();
    }

    @PutMapping("/readers/{id}")
    public Reader updateReader(@PathVariable Long id, @RequestBody Reader readerDetails) {
        System.out.println("Updating Reader ID: " + id);
        Reader reader = readerRepository.findById(id).orElseThrow(() -> new RuntimeException("Reader not found"));
        reader.setName(readerDetails.getName());
        reader.setEmail(readerDetails.getEmail());
        return readerRepository.save(reader);
    }

    @DeleteMapping("/readers/{id}")
    public String deleteReader(@PathVariable Long id) {
        System.out.println("Deleting Reader ID: " + id);
        readerRepository.deleteById(id);
        return "Deleted Successfully";
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        System.out.println("Adding Book: " + book.getTitle());
        return bookRepository.save(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        System.out.println("Fetching all books...");
        return bookRepository.findAll();
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        System.out.println("Updating Book ID: " + id);
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(bookDetails.getTitle());
        book.setPublishDate(bookDetails.getPublishDate());
        book.setReader(bookDetails.getReader());
        book.setCategory(bookDetails.getCategory());
        book.setAuthor(bookDetails.getAuthor());
        return bookRepository.save(book);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable Long id) {
        System.out.println("Deleting Book ID: " + id);
        bookRepository.deleteById(id);
        return "Deleted Successfully";
    }

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author) {
        System.out.println("Adding Author: " + author.getName());
        return authorRepository.save(author);
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        System.out.println("Fetching all authors...");
        return authorRepository.findAll();
    }

    @PutMapping("/authors/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author authorDetails) {
        System.out.println("Updating Author ID: " + id);
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        author.setName(authorDetails.getName());
        return authorRepository.save(author);
    }

    @DeleteMapping("/authors/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        System.out.println("Deleting Author ID: " + id);
        authorRepository.deleteById(id);
        return "Deleted Successfully";
    }

    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category) {
        System.out.println("Adding Category: " + category.getName());
        return categoryRepository.save(category);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        System.out.println("Fetching all categories...");
        return categoryRepository.findAll();
    }

    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        System.out.println("Updating Category ID: " + id);
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(categoryDetails.getName());
        return categoryRepository.save(category);
    }

    @DeleteMapping("/categories/{id}")
    public String deleteCategory(@PathVariable Long id) {
        System.out.println("Deleting Category ID: " + id);
        categoryRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
