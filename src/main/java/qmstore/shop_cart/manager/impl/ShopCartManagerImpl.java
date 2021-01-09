package qmstore.shop_cart.manager.impl;

import org.springframework.stereotype.Component;
import qmstore.shop_cart.dao.ShopCartDao;
import qmstore.shop_cart.manager.ShopCartManager;
import qmstore.shop_cart.pojo.ShopCart;
import qmstore.util.Response;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Component
public class ShopCartManagerImpl implements ShopCartManager {
    @Resource
    ShopCartDao shopCartDao;


    @Override
    public Response getShopCartByUser(String userId) {
        return Response.SUCCESS(shopCartDao.getShopCartByUser(userId));
    }

    @Override
    public Response getShopCartByGoods(String goodsId) {
        return Response.SUCCESS(shopCartDao.getShopCartByGoods(goodsId));
    }

    @Override
    public Response addShopCart(ShopCart shopCart) {
        ShopCart temp = shopCartDao.getShopCartByUserIdAndGoodsId(shopCart.getUserId(), shopCart.getGoodsId());
        if(temp != null && temp.getGoodsNum() >= 0){
            temp.setGoodsNum(temp.getGoodsNum() + shopCart.getGoodsNum());
            temp.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            return updateShopCart(temp);
        }
        if(shopCart.getGoodsNum() >= 0) {
            shopCart.setCreateTime(new Timestamp(System.currentTimeMillis()));
            shopCart.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            shopCartDao.addShopCart(shopCart);
            return Response.SUCCESS();
        }
        return Response.FAIL("商品数量不能小于0");
    }

    @Override
    public Response deleteShopCartByUserAndGoodsId(String userId, String goodsId) {
        shopCartDao.deleteShopCartByUserAndGoodsId(userId, goodsId);
        return Response.SUCCESS();
    }

    @Override
    public Response updateShopCart(ShopCart shopCart) {
        if(shopCart.getGoodsNum() >= 0) {
            shopCart.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            shopCartDao.updateShopCart(shopCart);
            return Response.SUCCESS();
        }
        return Response.FAIL("商品数量不能小于0");
    }

}
