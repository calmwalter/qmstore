package qmstore.user.controller;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.springframework.web.bind.annotation.*;
import qmstore.commodity.dao.CommodityMapper;
import qmstore.commodity.pojo.Commodity;
import qmstore.user.dao.UserMapper;
import qmstore.user.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    private String resource = "mybatis-config.xml";


    @GetMapping("/all")
    public ArrayList<User> findAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        ArrayList<User> users = userMapper.findAll();
        sqlSession.close();
        inputStream.close();
        return users;
    }

}
