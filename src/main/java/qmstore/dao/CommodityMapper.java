package qmstore.dao;

import qmstore.pojo.Commodity;

import java.util.ArrayList;

public interface CommodityMapper {
    ArrayList<Commodity> findAll();
    void add(Commodity commodity);
    int update(Commodity commodity);
    int delete(int id);
}
