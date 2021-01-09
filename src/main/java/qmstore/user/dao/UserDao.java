package qmstore.user.dao;

import org.springframework.stereotype.Repository;
import qmstore.user.pojo.User;

import java.util.List;

@Repository
public interface UserDao {
    public String getPassword(String userId);

    public User getUser(String userId);

    public void addUser(User user);

    public String getUserId(String userId);

    public void updateUser(User user);

    public List<User> getAllUser();

    public int deleteUserByUserId(String userId);

}
