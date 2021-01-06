package qmstore.user.dao;

import java.util.ArrayList;

import qmstore.commodity.pojo.Commodity;
import qmstore.user.pojo.User;

public interface UserMapper {
    ArrayList<User> findAll();
    int add(User user);
    int update(User user);
    int delete(int userid);
}
