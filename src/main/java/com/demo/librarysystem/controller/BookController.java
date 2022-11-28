package com.demo.librarysystem.controller;

import com.demo.librarysystem.service.LibraryServiceImpl;
import com.demo.librarysystem.ServiceImplementation.DeleteServiceImpl.DeleteService;
import com.demo.librarysystem.ServiceImplementation.DeleteServiceImpl.DeleteServiceByAuthor;
import com.demo.librarysystem.service.GetAllBooks;
import com.demo.librarysystem.service.AuthorAndTitleService;
import com.demo.librarysystem.service.AuthorService;
import com.demo.librarysystem.service.TitleService;
import com.demo.librarysystem.service.bookIdService;
import com.demo.librarysystem.model.Books;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController("/api")
public class BookController {

    //@CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/api/author/{authorName}")
    public List<Map<String, Object>> getBookByAuthor(@PathVariable("authorName") String authorName) throws SQLException {
        AuthorService authorService = new AuthorService();
        List<Map<String, Object>> result = authorService.searchbyAuthor(authorName);
        return result;
    }

    @GetMapping(value = "/api/book/{id}")
    public List<Map<String,Object>> getBookById(@PathVariable int id) throws SQLException, IOException {
        bookIdService idService = new bookIdService();
        List<Map<String,Object>> result = idService.searchById(id);
        return result;
    }

    @GetMapping(value = "/title/{titleName}")
    public void getBookByTitle(@PathVariable String titleName) throws SQLException, IOException {
        TitleService titleService = new TitleService();
        titleService.searchbyTitle(titleName);

    }

    @GetMapping("/api/book/all")
    public List<Map<String, Object>> findAll() throws SQLException {
        GetAllBooks allBooks = new GetAllBooks();
        List<Map<String, Object>> result = allBooks.getAll();
        return result;
    }

    @GetMapping(value = "/find")
    public List<Map<String, Object>> findBooks(@RequestParam("authorName") String authorName ,
                                               @RequestParam("titleName") String titleName) throws SQLException {
        AuthorAndTitleService AandT = new AuthorAndTitleService();
        List<Map<String, Object>> result = AandT.searchbyAuthorAndTitle(authorName, titleName);
        return result;
    }

    @PutMapping(value = "/book")
    public void update(@RequestBody Books book) throws SQLException {
        System.out.println(book);
        AuthorService authorService = new AuthorService();
        authorService.updateAuthor(book);
    }

    @PostMapping(value = "/api/book")
    public void createBook(@RequestBody Books book) throws SQLException {
        LibraryServiceImpl libraryService = new LibraryServiceImpl();
         libraryService.addBook(book);
    }

    @DeleteMapping("/api/book/{id}")
    public void deleteByIdAPI(@PathVariable int id) throws SQLException {
        DeleteService deleteService = new DeleteService();
        deleteService.deleteById(id);
    }
    @DeleteMapping("/book1/{author}")
    public void deleteByAuthorAPI(@PathVariable String author) throws SQLException {
        DeleteServiceByAuthor deleteService = new DeleteServiceByAuthor();
        deleteService.deleteByAuthor(author);
    }

}
