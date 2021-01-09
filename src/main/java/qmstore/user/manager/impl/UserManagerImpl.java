package qmstore.user.manager.impl;

import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import qmstore.user.condition.RegisterCondition;
import qmstore.user.constant.DataType;
import qmstore.user.dao.UserDao;
import qmstore.user.manager.UserManager;
import qmstore.user.pojo.User;
import qmstore.util.Response;
import qmstore.util.UserUtil;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserManagerImpl implements UserManager {

    @Resource
    private UserDao userDao;

    @Override
    public User getUser(String userId) {
        return userDao.getUser(userId);
    }

    @Override
    public boolean checkPassword(String userId, String password) {
        String answer = userDao.getPassword(userId);
        //判断用户存在并且密码匹配
        return !answer.equals("") && answer.equals(password);
    }

    @Override
    public Response UserLogin(String userId, String password) {
        try {

            if (checkPassword(userId, password)) {
                System.out.println("public Response UserLogin userId = " + userId);
                User user = this.getUser(userId);
                System.out.println("public Response UserLogin user = " + user);
                if (user.getUserGroup().equals("CUSTOMER") || user.getUserGroup().equals("normal")) {
                    System.out.println("user is customer");
                    user.setUserType(DataType.CUSTOMER);
                }else if(user.getUserGroup().equals("admin")){
                    user.setUserType(DataType.ADMIN);
                }
//                user.setCreateDate(DateUtil.date(user.getCreateTime()));
//                user.setUpdateDate(DateUtil.date(user.getUpdateDate()));
                UserUtil.set(user);
                return Response.SUCCESS(user);
            }
            return Response.ERROR("账号或密码错误");
        }catch (Exception e){
            System.out.println("public Response UserLogin e.getMessage() = " + e.getMessage());
            return Response.ERROR(e.getMessage());
        }
    }


    @Override
    public Response UserRegister(RegisterCondition user) {
        try {
            //检测账号是否存在
            if (!StringUtils.isEmpty(userDao.getUserId(user.getUserId()))) {
                return Response.FAIL("账号已存在");
            }

            //检查密码是否正确
            if (!validatePassword(user.getFirstPassword(), user.getSecondPassword())) {
                return Response.FAIL("密码错误");
            }

            //检查手机号码是否正确
            if (!isPhone(user.getPhone())) {
                return Response.FAIL("手机号码输入有误");
            }

            //检查邮箱是否正确
            if (!isEmail(user.getEmail())) {
                return Response.FAIL("邮箱输入有误");
            }

            //检查用户名是否正确
            if (StringUtils.isEmpty(user.getUserName())) {
                return Response.FAIL("用户名有误");
            }

            User newUser = new User();
            newUser.setUserId(user.getUserId());
            newUser.setUserName(user.getUserName());
            newUser.setPassword(user.getFirstPassword());
            newUser.setPhone(user.getPhone());
            newUser.setEmail(user.getEmail());
            newUser.setCreateTime(new Timestamp(System.currentTimeMillis()));
            newUser.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            newUser.setUserGroup("CUSTOMER");
            userDao.addUser(newUser);
            return Response.SUCCESS();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }

    }

    @Override
    public Response changeUser(RegisterCondition user) {
        try {
            //检查用户名是否正确
            if (StringUtils.isEmpty(user.getUserName())) {
                return Response.FAIL("用户名有误");
            }

            //检查密码是否正确
            if (!validatePassword(user.getFirstPassword(), user.getSecondPassword())) {
                return Response.FAIL("密码错误");
            }

            //检查手机号码是否正确
            if (!isPhone(user.getPhone())) {
                return Response.FAIL("手机号码输入有误");
            }

            //检查邮箱是否正确
            if (!isEmail(user.getEmail())) {
                return Response.FAIL("邮箱输入有误");
            }

            User newUser = new User();
            newUser.setUserName(user.getUserName());
            newUser.setPassword(user.getFirstPassword());
            newUser.setPhone(user.getPhone());
            newUser.setEmail(user.getEmail());
            newUser.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            userDao.updateUser(newUser);

            return Response.SUCCESS();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @Override
    public Response getAllUser() {
        return Response.SUCCESS(userDao.getAllUser());
    }

    @Override
    public Response UserLogOut(){
        try {
            UserUtil.remove();
            return Response.SUCCESS();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @Override
    public Response deleteUserByUserId(String userId) {
        try {
            return Response.SUCCESS(userDao.deleteUserByUserId(userId));
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }


    private boolean validatePassword(String firstPassword, String secondPassword){

        return !StringUtils.isEmpty(firstPassword) && firstPassword.equals(secondPassword);
    }

    private boolean isPhone(String phone){
        String returnStr = "";
        if (StringUtils.isEmpty(phone))
            return true;

        if (!StringUtils.isEmpty(returnStr)) {
            // 校验手机
            if (phone.length() == 11) {
                if (phone.matches("[1][3|4|5|7|8|9]\\d{9}")) {
                    returnStr = "";
                    return true;
                } else {
                    returnStr = "手机号码不正确！";
                    return false;
                }
            } else {
                returnStr = "手机号码位数错误！";
                return false;
            }

        }

        return true;
    }

    public boolean isEmail(String email) {
        if (StringUtils.isEmpty(email))
            return true;
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(email);
        if (m.matches())
            return true;
        else
            return false;
    }




}
