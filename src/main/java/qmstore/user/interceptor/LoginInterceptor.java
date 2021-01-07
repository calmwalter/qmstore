package qmstore.user.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import qmstore.user.annotation.DataAuth;
import qmstore.user.pojo.User;
import sun.plugin2.liveconnect.ArgumentHelper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        String url = request.getServletPath();
        System.out.println("post URL："+url);

//        Annotation[][] annotations = ((HandlerMethod) handler).getMethod().getParameterAnnotations();

        Parameter[] parameters = ((HandlerMethod) handler).getMethod().getParameters();
        for(Parameter parameter : parameters){
            Annotation[] annotations = parameter.getAnnotations();
            for(Annotation annotation : annotations){
                if(annotation.annotationType().equals(DataAuth.class)){

                }
            }
        }
        //参数注解，1维是参数，2维是注解
//        for (Annotation[] annotation : annotations) {
//            if (annotation.length == 0) {
//                continue;
//            }
//
//            for (Annotation ann : annotation) {
//                if (ann.annotationType().equals(DataAuth.class)) {
//                    System.out.println("123");
//                    break;
//                }
//            }
//
//        }

        if(!url.equals("")){
            //判断是否已经登录
            User loginUser = (User)request.getSession().getAttribute("user");
            if(loginUser == null){
                //無session則是未登录狀態
                System.out.println(">>>未登录，請重新登录<<<");
                response.sendRedirect("../loginAndRegist.jsp");
                return false;
            }
        }
        return true;
    }


}
