package qmstore.shop_cart.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import qmstore.shop_cart.pojo.ShopCart;

@Repository
public interface ShopCartDao {
    public ShopCart getShopCartByUser(String userId);
    public ShopCart getShopCartByGoods(String goodsId);
    public void addShopCart(ShopCart shopCart);
    public void deleteShopCartByUserAndGoodsId(@Param("userId")String userId, @Param("GoodsId") String GoodsId);
    public void updateShopCart(ShopCart shopCart);
}
