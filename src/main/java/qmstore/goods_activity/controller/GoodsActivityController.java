package qmstore.goods_activity.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import qmstore.goods_activity.dao.GoodsActivityMapper;
import qmstore.goods_activity.pojo.GoodsActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class GoodsActivityController {
    private String resource = "mybatis-config.xml";

    @GetMapping("/all")
    public ArrayList<GoodsActivity> findAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsActivityMapper goodsActivityMapper = sqlSession.getMapper(GoodsActivityMapper.class);
        ArrayList<GoodsActivity> goodsActivities = goodsActivityMapper.findAll();
        sqlSession.close();
        inputStream.close();
        return goodsActivities;
    }

    @PostMapping("/add")
    public GoodsActivity add(@RequestBody GoodsActivity goodsActivity) throws IOException {
        //TODO 管理员身份验证
        //TODO 时间戳活动id创建
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsActivityMapper goodsActivityMapper = sqlSession.getMapper(GoodsActivityMapper.class);

        goodsActivityMapper.add(goodsActivity);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
        System.out.println(goodsActivity.getId());

        return goodsActivity;
    }

    @PostMapping("/update")
    public void update(@RequestBody GoodsActivity goodsActivity) throws IOException {
        //TODO 管理员身份验证
        //TODO 活动种类存在校验
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsActivityMapper goodsActivityMapper = sqlSession.getMapper(GoodsActivityMapper.class);

        int res = goodsActivityMapper.update(goodsActivity);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @GetMapping("/delete")
    public void delete(@RequestParam("id") int id) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsActivityMapper goodsActivityMapper = sqlSession.getMapper(GoodsActivityMapper.class);

        int res = goodsActivityMapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @GetMapping("/find")
    public GoodsActivity find(@RequestParam("id") int id) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsActivityMapper goodsActivityMapper = sqlSession.getMapper(GoodsActivityMapper.class);

        GoodsActivity res = goodsActivityMapper.find(id);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();

        return res;

    }
}
