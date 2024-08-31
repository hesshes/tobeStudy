package com.hesshes.studytobe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hesshes.studytobe.domain.User;
import com.hesshes.studytobe.exception.DuplicateUserIdException;
import com.mysql.cj.exceptions.MysqlErrorNumbers;

//list 5-11
public interface UserDao {
    void add(User user);

    User get(String id);

    List<User> getAll();

    void deleteAll();

    int getCount();
    
    void update(User user1);

}
