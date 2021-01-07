package qmstore.goods_detail.dao;

import qmstore.activity_category.pojo.ActivityCategory;
import qmstore.goods_detail.pojo.GoodsDetail;

import java.util.ArrayList;

public interface GoodsDetailMapper {
    ArrayList<GoodsDetail> findAll();
    void add(GoodsDetail goodsDetail);
    int update(GoodsDetail goodsDetail);
    int delete(int id);
    GoodsDetail find(int id);
}
