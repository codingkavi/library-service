package com.demo.librarysystem.Controller;

import com.demo.librarysystem.BookService.LibraryServiceImpl;
import com.demo.librarysystem.ServiceImplementation.DeleteServiceImpl.DeleteService;
import com.demo.librarysystem.ServiceImplementation.DeleteServiceImpl.DeleteServiceByAuthor;
import com.demo.librarysystem.ServiceImplementation.GetAllBooks;
import com.demo.librarysystem.ServiceImplementation.SearchImpl.AuthorAndTitleService;
import com.demo.librarysystem.ServiceImplementation.SearchImpl.AuthorService;
import com.demo.librarysystem.ServiceImplementation.SearchImpl.TitleService;
import com.demo.librarysystem.ServiceImplementation.SearchImpl.bookIdService;
import com.demo.librarysystem.model.Books;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;
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
    public Map<String, Object> getBookById(@PathVariable int id) throws SQLException, JsonProcessingException {
        bookIdService idService = new bookIdService();
        Map<String, Object> result = idService.searchById(id);
        return result;
    }

    @GetMapping(value = "/title/{titleName}")
    public List<Map<String, Object>> getBookByTitle(@PathVariable String titleName) throws SQLException {
        TitleService titleService = new TitleService();
        List<Map<String, Object>> result = titleService.searchbyTitle(titleName);
        return result;
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

    @PutMapping(value = "/api/book")
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
