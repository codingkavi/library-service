package com.demo.librarysystem.util;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface findUser {

    List<Map<String, Object>> findbyLastname(String lastname) throws SQLException;
}
