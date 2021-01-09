package qmstore.goods_detail.dao;

import qmstore.activity_category.pojo.ActivityCategory;
import qmstore.goods_detail.pojo.GoodsDetail;

import java.util.ArrayList;
import java.util.List;

public interface GoodsDetailMapper {
    ArrayList<GoodsDetail> findAll();
    void add(GoodsDetail goodsDetail);
    int update(GoodsDetail goodsDetail);
    int delete(String id);
    ArrayList<GoodsDetail> find(String id);
    List<GoodsDetail> getAllByCategory(String categoryCode);
}
