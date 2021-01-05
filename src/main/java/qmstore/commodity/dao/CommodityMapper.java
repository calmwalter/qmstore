package qmstore.commodity.dao;

import qmstore.commodity.pojo.Commodity;

import java.util.ArrayList;

public interface CommodityMapper {
    ArrayList<Commodity> findAll();
    void add(Commodity commodity);
    int update(Commodity commodity);
    int delete(int id);
}
