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
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController("/api")
public class BookController {

    @GetMapping(value = "/book/{authorName}")
    public List<Map<String, Object>> getBookbyAuthor(@PathVariable("authorName") String authorName) throws SQLException {
        AuthorService authorService = new AuthorService();
        List<Map<String, Object>> result = authorService.searchbyAuthor(authorName);
        return result;
    }

    @GetMapping(value = "/bookid/{id}")
    public List<Map<String, Object>> getBookbyId(@PathVariable int id) throws SQLException {
        bookIdService IdService = new bookIdService();
        List<Map<String, Object>> result = IdService.searchbyId(id);
        return result;

    }

    @GetMapping(value = "/title/{titleName}")
    public List<Map<String, Object>> getBookbyTitle(@PathVariable String titleName) throws SQLException {
        TitleService titleService = new TitleService();
        List<Map<String, Object>> result = titleService.searchbyTitle(titleName);
        return result;
    }

    @GetMapping("/")
    public List<Map<String, Object>> findAll() throws SQLException {
        GetAllBooks allBooks = new GetAllBooks();
        List<Map<String, Object>> result = allBooks.getAll();
        return result;
    }

    @GetMapping(value = "/find?authorName={authorName}&titleName={titleName}")
    public List<Map<String, Object>> findBooks(@PathVariable String authorName, @PathVariable String titleName) throws SQLException {
        AuthorAndTitleService AandT = new AuthorAndTitleService();
        List<Map<String, Object>> result = AandT.searchbyAuthorAndTitle(authorName, titleName);
        return result;
    }

    @PutMapping(value = "/book/update")
    public void update(@RequestBody Books book) throws SQLException {
        System.out.println(book);
        AuthorService authorService = new AuthorService();
        authorService.updateAuthor(book);

    }

    @PostMapping(value = "/book")
    public Books createBook(@RequestBody Books book) throws SQLException {

        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        Books result = libraryService.addBook(book);
        return result;

    }

    @DeleteMapping("/book/{id}")
    public void deleteByIdAPI(@PathVariable int id) throws SQLException {
        DeleteService deleteService = new DeleteService();
        deleteService.deleteById(id);
    }
    @DeleteMapping("/book1/{author}")
    public void deleteByAuthorAPI(@PathVariable String author) throws SQLException {
        DeleteServiceByAuthor deleteService = new DeleteServiceByAuthor();
        deleteService.deleteByAuthor(author);
    }

    @PatchMapping(value ="/{id}")
    public void saveBook(@PathVariable("bookId") int id,@RequestBody Books book){
        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        libraryService.addBook(book);
    }
}
