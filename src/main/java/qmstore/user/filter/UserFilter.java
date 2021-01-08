package qmstore.user.filter;

import qmstore.user.pojo.User;
import qmstore.util.UserUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("public void doFilter(ServletRequest 拦截请求");
        User user = UserUtil.get();
        System.out.println("public void doFilter(ServletRequest user = " + user);
        if(user == null){
            user = (User) UserUtil.getSession().getAttribute(UserUtil.SESSION_USER);
            System.out.println("public void doFilter(ServletRequest new user = " + user);
        }
        UserUtil.set(user);
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
