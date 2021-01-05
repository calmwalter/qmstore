package qmstore.commodity.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.springframework.web.bind.annotation.*;
import qmstore.commodity.dao.CommodityMapper;
import qmstore.commodity.pojo.Commodity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@RestController
@RequestMapping("/commodity")
public class CommodityController {
    private String resource = "mybatis-config.xml";


    @GetMapping("/all")
    public ArrayList<Commodity> findAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityMapper commodityMapper = sqlSession.getMapper(CommodityMapper.class);
        ArrayList<Commodity> commodities = commodityMapper.findAll();
        sqlSession.close();
        inputStream.close();
        return commodities;
    }

    @PostMapping("/add")
    public Commodity add(@RequestBody Commodity commodity) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityMapper commodityMapper = sqlSession.getMapper(CommodityMapper.class);
        System.out.println(commodity);

        commodityMapper.add(commodity);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
        System.out.println(commodity.getId());

        return commodity;
    }

    @PostMapping("/update")
    public void update(@RequestBody Commodity commodity) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityMapper commodityMapper = sqlSession.getMapper(CommodityMapper.class);

        int res = commodityMapper.update(commodity);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @GetMapping("/delete")
    public void delete(@RequestParam("id") int id) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityMapper commodityMapper = sqlSession.getMapper(CommodityMapper.class);

        int res = commodityMapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

}
