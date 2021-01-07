package qmstore.user.interceptor;

import javax.security.auth.login.LoginContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import qmstore.user.annotation.DataAuth;
import qmstore.user.pojo.User;
import qmstore.util.UserUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;

public class LoginInterceptor implements HandlerMethodArgumentResolver {

    /**
     * 符合条件的注解会进入到当前解析
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(DataAuth.class);
    }

    /**
     * 解析获取对应的数据
     * @param methodParameter
     * @param modelAndViewContainer
     * @param nativeWebRequest
     * @param webDataBinderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        try{
            User user = UserUtil.get();
            if(user == null || user.getUserId() == null || user.getUserId().equals("")){
                return null;
            }
            return user;

        }catch (RuntimeException e){
            throw new RuntimeException("获取用户权限信息异常");
        }
    }
}
