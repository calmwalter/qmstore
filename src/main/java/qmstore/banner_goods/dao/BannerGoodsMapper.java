package qmstore.banner_goods.dao;

import qmstore.banner_goods.pojo.BannerGoods;

import java.util.ArrayList;

public interface BannerGoodsMapper {
    ArrayList<BannerGoods> findAll();
    void add(BannerGoods bannerGoods);
    int update(BannerGoods bannerGoods);
    int delete(int id);
    BannerGoods find(int id);
}
