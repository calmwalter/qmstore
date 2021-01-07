package qmstore.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import qmstore.user.pojo.User;

import javax.servlet.http.HttpSession;

public class UserUtil {
    private UserUtil(){}

    public static final String SESSION_USER = "user";
    private static final ThreadLocal<User> USER = new ThreadLocal<>();

    public static void set(User user){
        USER.set(user);
        HttpSession session = getSession();
        session.setAttribute(SESSION_USER, user);
        System.out.println("session getAttribute = " + session.getAttribute(SESSION_USER));
        System.out.println(" UserUtil.get() = " + UserUtil.get());
    }

    public static User get() {
        System.out.println( "当前线程 get：" + Thread.currentThread().getName() );
        System.out.println(getSession().getAttribute(SESSION_USER));
        return USER.get();
    }

    public static void remove(){
        HttpSession session = getSession();
        session.removeAttribute(SESSION_USER);
        USER.remove();
    }

    /**
     * 获取当前 Request
     */
    public static HttpSession getSession() {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        return session;
    }

}
