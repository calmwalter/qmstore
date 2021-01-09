package qmstore.shop_cart.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import qmstore.shop_cart.pojo.ShopCart;

import java.util.List;

@Repository
public interface ShopCartDao {
    public List<ShopCart> getShopCartByUser(String userId);
    public List<ShopCart> getShopCartByGoods(String goodsId);
    public void addShopCart(ShopCart shopCart);
    public void deleteShopCartByUserAndGoodsId(@Param("userId")String userId, @Param("GoodsId") String GoodsId);
    public void updateShopCart(ShopCart shopCart);
}
