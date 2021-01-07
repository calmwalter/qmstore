package qmstore.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qmstore.user.condition.LoginCondition;
import qmstore.user.condition.RegisterCondition;
import qmstore.user.manager.impl.UserManagerImpl;
import qmstore.util.Response;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserManagerImpl userManager;

    @PostMapping("/login")
    public Response userLogin(@RequestBody LoginCondition loginCondition){
        System.out.println("123123");
        try {
            return userManager.UserLogin(loginCondition.getUserId(), loginCondition.getPassword());
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
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



}

