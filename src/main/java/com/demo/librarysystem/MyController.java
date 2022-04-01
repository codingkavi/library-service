package com.demo.librarysystem;

import com.demo.librarysystem.ServiceImplementation.Search.AuthorAndTitleService;
import com.demo.librarysystem.ServiceImplementation.Search.AuthorService;
import com.demo.librarysystem.ServiceImplementation.Search.TitleService;
import com.demo.librarysystem.model.Books;
import com.demo.librarysystem.repository.BookRepository;
import com.demo.librarysystem.service.LibraryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController("/find")
public class MyController {

    @RequestMapping(value = "/findAPI/{authorName}",method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Map<String, Object>> findBookbyAuthor(@PathVariable("authorName") String authorName) throws SQLException {
        AuthorService authorService = new AuthorService();

        List<Map<String, Object>> bookResponse = authorService.findBook(authorName);
        return bookResponse;
    }



    @RequestMapping(value = "/search/{titleName}",method = GET)
    public String findBookbyTitle(@PathVariable("titleName") String titleName) throws SQLException {
        TitleService titleService = new TitleService();
        String result = titleService.findBook(titleName);
        return result;
    }

  @RequestMapping(value = "/find?authorName={authorName}&titleName={titleName}")
    public List<Map<String, Object>> findBooks(@PathVariable(value = "authorName") String authorName, @PathVariable(value = "titleName") String titleName) throws SQLException {
      AuthorAndTitleService AandT = new AuthorAndTitleService();
      List<Map<String, Object>> result = AandT.searchbyAuthorAndTitle(authorName,titleName);
      return result;
    }

    @PostMapping(value = "/adduser")
    @ResponseBody
    public BookRepository createBook(@RequestBody Books books){
        LibraryService libraryService = new LibraryService();
        BookRepository result = libraryService.addBook(books);
        return result;
    }
    /*@Query(value = "SELECT * FROM Users u WHERE u.authorName = :authorName and u.titleName = :titleName",
            nativeQuery = true)
    public void findUser(@Param("authorName") String authorName, @Param("titleName") String titleName){


    }
*/

}
