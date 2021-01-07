package qmstore.activity_category.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qmstore.activity_category.dao.ActivityCategoryMapper;
import qmstore.activity_category.pojo.ActivityCategory;
import qmstore.commodity.dao.CommodityMapper;
import qmstore.commodity.pojo.Commodity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@RestController
@RequestMapping("/activity_category")
public class ActivityCategoryController {
    private String resource = "mybatis-config.xml";

    @GetMapping("/all")
    public ArrayList<ActivityCategory> findAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ActivityCategoryMapper activityCategoryMapper = sqlSession.getMapper(ActivityCategoryMapper.class);
        ArrayList<ActivityCategory> activityCategories = activityCategoryMapper.findAll();
        sqlSession.close();
        inputStream.close();
        return activityCategories;
    }
}
