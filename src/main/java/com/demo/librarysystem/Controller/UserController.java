package com.demo.librarysystem.Controller;


import com.demo.librarysystem.UserService.SearchUser.ServiceImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/user/{lastname}")
    public List<Map<String, Object>> find(@PathVariable String lastname) throws SQLException {
        ServiceImpl findName = new ServiceImpl();
        List<Map<String, Object>> result =  findName.findByLastname(lastname);
        return result;
    }

    @DeleteMapping("/user/{username}")
    public void delete(@PathVariable String username) throws SQLException {
        ServiceImpl deleteUser = new ServiceImpl();
        deleteUser.deletebyname(username);
    }
}
