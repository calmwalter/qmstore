package qmstore.user.listener;

import qmstore.util.UserUtil;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class LoginListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request  = (HttpServletRequest) sre.getServletRequest();
        /**
         * 移除当前线程绑定的用户数据，防止内存泄露
         */
        UserUtil.threadRemove();
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

    }
}
