package qmstore.shop_cart.manager;

import qmstore.shop_cart.pojo.ShopCart;
import qmstore.util.Response;

public interface ShopCartManager {
    public Response getShopCartByUser(String userId);
    public Response getShopCartByGoods(String goodsId);
    public Response addShopCart(ShopCart shopCart);
    public Response deleteShopCartByUserAndGoodsId(String userId, String goodsId);
    public Response updateShopCart(ShopCart shopCart);

}
