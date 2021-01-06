package qmstore.user.manager.impl;

import qmstore.user.manager.UserManager;
import qmstore.user.pojo.User;

public class UserManagerImpl implements UserManager {
    @Override
    public User getUser(String userId) {
        return null;
    }

    @Override
    public boolean checkPassword(String userId, String password) {

        return false;
    }
}
