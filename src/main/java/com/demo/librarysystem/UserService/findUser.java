package com.demo.librarysystem.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface findUser {

    List<Map<String, Object>> findByLastname(String lastname) throws SQLException;

}
