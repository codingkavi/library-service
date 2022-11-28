package com.demo.librarysystem.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface findUser {

     void findByLastname(String lastname) throws SQLException;

}
