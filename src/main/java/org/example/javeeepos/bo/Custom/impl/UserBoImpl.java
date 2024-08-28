package org.example.javeeepos.bo.Custom.impl;

import org.example.javeeepos.bo.Custom.UserBo;
import org.example.javeeepos.dao.custom.UserDao;
import org.example.javeeepos.dao.custom.impl.UserDaoImpl;
import org.example.javeeepos.dto.UserDto;
import org.example.javeeepos.entity.User;

import javax.naming.NamingException;
import java.sql.SQLException;

public class UserBoImpl implements UserBo{

    UserDao userDao = new UserDaoImpl();
    @Override
    public boolean saveUser(UserDto userDto) throws SQLException, NamingException {
        return userDao.save(new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getPassword()
        ));
    }

    @Override
    public UserDto getUser(String id) throws SQLException, NamingException {
        User user =  userDao.get(id);
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getPassword()
        );
    }
}
