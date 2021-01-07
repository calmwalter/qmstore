package qmstore.util;

import qmstore.user.pojo.User;

public class UserUtil {
    private UserUtil(){}

    private static final ThreadLocal<User> USER = new ThreadLocal<>();

    public static void set(User user){
        USER.set(user);
    }

    public static User get() {
        return USER.get();
    }

    public static void remove(){
        USER.remove();
    }


}
