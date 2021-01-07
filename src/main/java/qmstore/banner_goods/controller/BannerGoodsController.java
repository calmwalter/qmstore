package qmstore.banner_goods.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import qmstore.banner_goods.dao.BannerGoodsMapper;
import qmstore.banner_goods.pojo.BannerGoods;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@Controller
@RequestMapping("/banner_goods")
public class BannerGoodsController {
    private String resource = "mybatis-config.xml";

    @GetMapping("/all")
    public ArrayList<BannerGoods> findAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BannerGoodsMapper bannerGoodsMapper = sqlSession.getMapper(BannerGoodsMapper.class);
        ArrayList<BannerGoods> bannerGoods = bannerGoodsMapper.findAll();
        sqlSession.close();
        inputStream.close();
        return bannerGoods;
    }

    @PostMapping("/add")
    public BannerGoods add(@RequestBody BannerGoods bannerGoods) throws IOException {
        //TODO 管理员身份验证
        //TODO 时间戳活动id创建
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BannerGoodsMapper bannerGoodsMapper = sqlSession.getMapper(BannerGoodsMapper.class);

        bannerGoodsMapper.add(bannerGoods);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
        System.out.println(bannerGoods.getId());

        return bannerGoods;
    }

    @PostMapping("/update")
    public void update(@RequestBody BannerGoods bannerGoods) throws IOException {
        //TODO 管理员身份验证
        //TODO 活动种类存在校验
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BannerGoodsMapper bannerGoodsMapper = sqlSession.getMapper(BannerGoodsMapper.class);

        int res = bannerGoodsMapper.update(bannerGoods);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @GetMapping("/delete")
    public void delete(@RequestParam("id") int id) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BannerGoodsMapper bannerGoodsMapper = sqlSession.getMapper(BannerGoodsMapper.class);

        int res = bannerGoodsMapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @GetMapping("/find")
    public BannerGoods find(@RequestParam("id") int id) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BannerGoodsMapper bannerGoodsMapper = sqlSession.getMapper(BannerGoodsMapper.class);

        BannerGoods res = bannerGoodsMapper.find(id);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();

        return res;

    }
}
