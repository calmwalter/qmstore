package qmstore.goods_activity.dao;


import qmstore.goods_activity.pojo.GoodsActivity;

import java.util.ArrayList;

public interface GoodsActivityMapper {
    ArrayList<GoodsActivity> findAll();
    void add(GoodsActivity goodsActivity);
    int update(GoodsActivity goodsActivity);
    int delete(int id);
    GoodsActivity find(int id);
}
