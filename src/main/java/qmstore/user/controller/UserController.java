package qmstore.user.controller;

import org.springframework.web.bind.annotation.*;
import qmstore.user.annotation.DataAuth;
import qmstore.user.condition.LoginCondition;
import qmstore.user.condition.RegisterCondition;
import qmstore.user.constant.DataType;
import qmstore.user.manager.impl.UserManagerImpl;
import qmstore.user.pojo.User;
import qmstore.util.Response;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserManagerImpl userManager;

    @PostMapping("/login")
    public Response userLogin(@RequestBody LoginCondition loginCondition){
        try {
            return userManager.UserLogin(loginCondition.getUserId(), loginCondition.getPassword());
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @GetMapping("checkLoginStatus")
    public Response checkLoginStatus(@DataAuth User dataAuth){
        System.out.println("dataAuth = " + dataAuth);
        return Response.SUCCESS(dataAuth);
    }

    @PostMapping("register")
    public Response userRegister(@RequestBody RegisterCondition user){
        try {
            return userManager.UserRegister(user);
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @PostMapping("updateUser")
    public Response updateUser(@RequestBody RegisterCondition user){
        try {
            return userManager.changeUser(user);
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @GetMapping("getAllUer")
    public Response getAllUser(@DataAuth User user){
        if(user != null && user.getUserType().equals(DataType.ADMIN)){
            return userManager.getAllUser();
        }
        return Response.FAIL("无权限");
    }

    @GetMapping("logout")
    public Response userLogout(){
        return userManager.UserLogOut();
    }

    @GetMapping("deleteUser")
    public Response deleteUserByUserId(@DataAuth User user, @RequestParam("userId") String userId){
        try {
            if(user.getUserType().equals(DataType.ADMIN)) {
                return userManager.deleteUserByUserId(userId);
            }
            return Response.FAIL("没有权限");
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }



}

