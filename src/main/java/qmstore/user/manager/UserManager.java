package qmstore.user.manager;

import jdk.vm.ci.code.Register;
import qmstore.user.condition.RegisterCondition;
import qmstore.user.pojo.User;
import qmstore.util.Response;

public interface UserManager {
    //获取user对象
    public User getUser(String userId);

    //检查密码
    public boolean checkPassword(String userId, String password);

    //登录
    public Response UserLogin(String userId, String password);

    //注册
    public Response UserRegister(RegisterCondition condition);

    //修改用户信息
    public Response changeUser(RegisterCondition condition);
}
