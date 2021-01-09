package qmstore.goods_activity.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.*;

import qmstore.goods_activity.dao.GoodsActivityMapper;
import qmstore.goods_activity.pojo.GoodsActivity;
import qmstore.user.annotation.DataAuth;
import qmstore.user.constant.DataType;
import qmstore.user.pojo.User;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
@CrossOrigin(origins = "http://localhost:9528",allowCredentials = "true")
@RestController
@RequestMapping("/goods_activity")
public class GoodsActivityController {
//    private String resource = "mybatis-config.xml";
    @Resource
    GoodsActivityMapper goodsActivityMapper;

    @GetMapping("/all")
    public ArrayList<GoodsActivity> findAll() throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        GoodsActivityMapper goodsActivityMapper = sqlSession.getMapper(GoodsActivityMapper.class);
        ArrayList<GoodsActivity> goodsActivities = goodsActivityMapper.findAll();
//        sqlSession.close();
//        inputStream.close();
        return goodsActivities;
    }

    @PostMapping("/add")
    public GoodsActivity add(@RequestBody GoodsActivity goodsActivity, @DataAuth User user) throws IOException {
        //管理员身份验证
        if(user==null){
            return null;
        }
        if(user.getUserType()!= DataType.ADMIN){
            return null;
        }

//        //TODO 时间戳活动id创建
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        GoodsActivityMapper goodsActivityMapper = sqlSession.getMapper(GoodsActivityMapper.class);
        goodsActivity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        goodsActivity.setUpdateTime(new Timestamp(System.currentTimeMillis()));


        goodsActivityMapper.add(goodsActivity);
//        sqlSession.commit();
//        sqlSession.close();
//        inputStream.close();
        System.out.println(goodsActivity.getId());

        return goodsActivity;
    }

    @PostMapping("/update")
    public void update(@RequestBody GoodsActivity goodsActivity,@DataAuth User user) throws IOException {
        //管理员身份验证
        if(user==null){
            return ;
        }
        if(user.getUserType()!= DataType.ADMIN){
            return ;
        }
        //TODO 活动种类存在校验
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        GoodsActivityMapper goodsActivityMapper = sqlSession.getMapper(GoodsActivityMapper.class);
        goodsActivity.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        int res = goodsActivityMapper.update(goodsActivity);
//        sqlSession.commit();
//        sqlSession.close();
//        inputStream.close();
    }

    @GetMapping("/delete")
    public void delete(@RequestParam("id") String id,@DataAuth User user) throws IOException {
        //管理员身份验证
        if(user==null){
            return ;
        }
        if(user.getUserType()!= DataType.ADMIN){
            return ;
        }
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        GoodsActivityMapper goodsActivityMapper = sqlSession.getMapper(GoodsActivityMapper.class);

        int res = goodsActivityMapper.delete(id);
//        sqlSession.commit();
//        sqlSession.close();
//        inputStream.close();
    }

    @GetMapping("/find")
    public ArrayList<GoodsActivity> find(@RequestParam("id") String id) throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        GoodsActivityMapper goodsActivityMapper = sqlSession.getMapper(GoodsActivityMapper.class);

        ArrayList<GoodsActivity> res = goodsActivityMapper.find(id);
//        sqlSession.commit();
//        sqlSession.close();
//        inputStream.close();

        return res;

    }
}
