package qmstore.goods_detail.controller;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.*;
import qmstore.goods_detail.dao.GoodsDetailMapper;
import qmstore.goods_detail.pojo.GoodsDetail;
import qmstore.util.Response;


import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;

@RestController
@RequestMapping("/goods_detail")
public class  GoodsDetailController {
//    private String resource = "../qmstore/WEB_INF/applicationContext.xml";
    @Resource
    GoodsDetailMapper goodsDetailMapper;

    @GetMapping("/all")
    public ArrayList<GoodsDetail> findAll() throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        GoodsDetailMapper activityCategoryMapper = sqlSession.getMapper(GoodsDetailMapper.class);
        ArrayList<GoodsDetail> goodsDetails = goodsDetailMapper.findAll();
//        sqlSession.close();
//        inputStream.close();
        return goodsDetails;
    }

    @PostMapping("/add")
    public GoodsDetail add(@RequestBody GoodsDetail goodsDetail) throws IOException {
        //TODO 管理员身份验证
        //TODO 时间戳活动id创建
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        GoodsDetailMapper goodsDetailMapper = sqlSession.getMapper(GoodsDetailMapper.class);
        goodsDetail.setGoodsId("0002"+System.currentTimeMillis());

        goodsDetail.setCreateTime(new Timestamp(System.currentTimeMillis()));
        goodsDetail.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        goodsDetailMapper.add(goodsDetail);
//        sqlSession.commit();
//        sqlSession.close();
//        inputStream.close();
        System.out.println(goodsDetail.getId());

        return goodsDetail;
    }

    @PostMapping("/update")
    public void update(@RequestBody GoodsDetail goodsDetail) throws IOException {
        //TODO 管理员身份验证
        //TODO 活动种类存在校验
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        GoodsDetailMapper goodsDetailMapper = sqlSession.getMapper(GoodsDetailMapper.class);
        goodsDetail.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        int res = goodsDetailMapper.update(goodsDetail);
//        sqlSession.commit();
//        sqlSession.close();
//        inputStream.close();
    }

    @GetMapping("/delete")
    public void delete(@RequestParam("id") String id) throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        GoodsDetailMapper goodsDetailMapper = sqlSession.getMapper(GoodsDetailMapper.class);

        int res = goodsDetailMapper.delete(id);
//        sqlSession.commit();
//        sqlSession.close();
//        inputStream.close();
    }

    @GetMapping("/find")
    public ArrayList<GoodsDetail> find(@RequestParam("id") String id) throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        GoodsDetailMapper goodsDetailMapper = sqlSession.getMapper(GoodsDetailMapper.class);

        ArrayList<GoodsDetail> res = goodsDetailMapper.find(id);
//        sqlSession.commit();
//        sqlSession.close();
//        inputStream.close();

        return res;

    }


    @GetMapping("getAllByCategory")
    public Response getAllByCategory(@RequestParam("categoryCode") String categoryCode){
        try {
            if(!categoryCode.equals("-1")) {
                return Response.SUCCESS(goodsDetailMapper.getAllByCategory(categoryCode));
            }else {
                return Response.SUCCESS(goodsDetailMapper.findAll());
            }
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @GetMapping("bestSale")
    public Response getBestSale(@RequestParam("num") int num){

        try {
                return Response.SUCCESS(goodsDetailMapper.getBestSale(num));
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

}
