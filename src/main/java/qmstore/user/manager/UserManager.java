package qmstore.user.manager;

import qmstore.user.pojo.User;

public interface UserManager {
    //获取user对象
    public User getUser(String userId);

    //检查密码
    public boolean checkPassword(String userId, String password);
}
