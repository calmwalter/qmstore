package qmstore.goods_detail.controller;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import qmstore.goods_detail.dao.GoodsDetailMapper;
import qmstore.goods_detail.pojo.GoodsDetail;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@RestController
@RequestMapping("/goods_detail")
public class  GoodsDetailController {
    private String resource = "mybatis-config.xml";

    @GetMapping("/all")
    public ArrayList<GoodsDetail> findAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsDetailMapper activityCategoryMapper = sqlSession.getMapper(GoodsDetailMapper.class);
        ArrayList<GoodsDetail> goodsDetails = activityCategoryMapper.findAll();
        sqlSession.close();
        inputStream.close();
        return goodsDetails;
    }

    @PostMapping("/add")
    public GoodsDetail add(@RequestBody GoodsDetail goodsDetail) throws IOException {
        //TODO 管理员身份验证
        //TODO 时间戳活动id创建
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsDetailMapper goodsDetailMapper = sqlSession.getMapper(GoodsDetailMapper.class);
        goodsDetail.setGoods_id("0002"+System.currentTimeMillis());

        goodsDetailMapper.add(goodsDetail);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
        System.out.println(goodsDetail.getId());

        return goodsDetail;
    }

    @PostMapping("/update")
    public void update(@RequestBody GoodsDetail goodsDetail) throws IOException {
        //TODO 管理员身份验证
        //TODO 活动种类存在校验
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsDetailMapper goodsDetailMapper = sqlSession.getMapper(GoodsDetailMapper.class);

        int res = goodsDetailMapper.update(goodsDetail);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @GetMapping("/delete")
    public void delete(@RequestParam("id") String id) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsDetailMapper goodsDetailMapper = sqlSession.getMapper(GoodsDetailMapper.class);

        int res = goodsDetailMapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @GetMapping("/find")
    public ArrayList<GoodsDetail> find(@RequestParam("id") String id) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsDetailMapper goodsDetailMapper = sqlSession.getMapper(GoodsDetailMapper.class);

        ArrayList<GoodsDetail> res = goodsDetailMapper.find(id);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();

        return res;

    }

}
