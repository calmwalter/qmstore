package qmstore.activity_category.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.*;
import qmstore.activity_category.dao.ActivityCategoryMapper;
import qmstore.activity_category.pojo.ActivityCategory;
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

@RestController
@RequestMapping("/activity_category")
public class ActivityCategoryController {
//    private String resource = "mybatis-config.xml";

    @Resource
    ActivityCategoryMapper activityCategoryMapper;

    @Resource
    GoodsActivityMapper goodsActivityMapper;

    @GetMapping("/all")
    public ArrayList<ActivityCategory> findAll() throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        ActivityCategoryMapper activityCategoryMapper = sqlSession.getMapper(ActivityCategoryMapper.class);
        ArrayList<ActivityCategory> activityCategories = activityCategoryMapper.findAll();
//        sqlSession.close();
//        inputStream.close();
        return activityCategories;
    }

    @PostMapping("/add")
    public ActivityCategory add(@RequestBody ActivityCategory activityCategory, @DataAuth User user) throws IOException {
        //管理员身份验证
        if(user==null){
            return null;
        }
        if(user.getUserType()!= DataType.ADMIN){
            return null;
        }
        //TODO 时间戳活动id创建
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        ActivityCategoryMapper activityCategoryMapper = sqlSession.getMapper(ActivityCategoryMapper.class);
        activityCategory.setActivityId("0001"+System.currentTimeMillis());
        activityCategory.setCreateTime(new Timestamp(System.currentTimeMillis()));
        activityCategory.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        activityCategoryMapper.add(activityCategory);
//        sqlSession.commit();
//        sqlSession.close();
//        inputStream.close();
        System.out.println(activityCategory.getId());

        return activityCategory;
    }

    @PostMapping("/update")
    public void update(@RequestBody ActivityCategory activityCategory,@DataAuth User user) throws IOException {
        // 管理员身份验证
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
//        ActivityCategoryMapper activityCategoryMapper = sqlSession.getMapper(ActivityCategoryMapper.class);
        activityCategory.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        int res = activityCategoryMapper.update(activityCategory);
//        sqlSession.commit();
//        sqlSession.close();
//        inputStream.close();
    }

    @GetMapping("/delete")
    public void delete(@RequestParam("id") String id,@DataAuth User user) throws IOException {
        // 管理员身份验证
        if(user==null){
            return ;
        }
        if(user.getUserType()!= DataType.ADMIN){
            return ;
        }
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        ActivityCategoryMapper activityCategoryMapper = sqlSession.getMapper(ActivityCategoryMapper.class);

        //删除关联
        ArrayList<GoodsActivity> goodsActivities = goodsActivityMapper.findAll();
        for(GoodsActivity goodsActivity :goodsActivities){
            if(goodsActivity.getActivityId()==id){
                goodsActivityMapper.delete(goodsActivity.getId());
            }
        }
        int res = activityCategoryMapper.delete(id);

//        sqlSession.commit();
//        sqlSession.close();
//        inputStream.close();
    }

    @GetMapping("/find")
    public ArrayList<ActivityCategory> find(@RequestParam("id") String id) throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        ActivityCategoryMapper activityCategoryMapper = sqlSession.getMapper(ActivityCategoryMapper.class);

        ArrayList<ActivityCategory> res = activityCategoryMapper.find(id);
//        sqlSession.commit();
//        sqlSession.close();
//        inputStream.close();

        return res;

    }
}
