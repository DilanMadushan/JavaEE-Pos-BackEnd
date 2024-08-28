package org.example.javeeepos.bo.Custom;

import org.example.javeeepos.bo.SuperBo;
import org.example.javeeepos.dto.UserDto;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface UserBo extends SuperBo {
    boolean saveUser(UserDto userDto) throws SQLException, NamingException;
    UserDto getUser(String id) throws SQLException, NamingException;
}
