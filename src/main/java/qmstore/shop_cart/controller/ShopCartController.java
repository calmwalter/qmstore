package qmstore.shop_cart.controller;

import org.springframework.web.bind.annotation.*;
import qmstore.shop_cart.manager.impl.ShopCartManagerImpl;
import qmstore.shop_cart.pojo.ShopCart;
import qmstore.user.annotation.DataAuth;
import qmstore.user.constant.DataType;
import qmstore.user.pojo.User;
import qmstore.util.Response;

import javax.annotation.Resource;

@RestController
@RequestMapping("/shopCart")
public class ShopCartController {
    @Resource
    ShopCartManagerImpl shopCartManager;

    /**
     * 通过用户id获得购物车
     * @param user
     * @param userId
     * @return
     */
    @GetMapping("/getShopCartByUser")
    public Response getShopCartByUser(@DataAuth User user, @RequestParam(value = "userId") String userId) {
        // 验证身份
        if (user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)) {
            return shopCartManager.getShopCartByUser(userId);
        }
        return Response.NOT_LOG_IN();
    }

    /**
     * 通过goodsId获得购物车
     * @param user
     * @param goodsId
     * @return
     */
    @GetMapping("/getShopCartByGoods")
    public Response getShopCartByGoods(@DataAuth User user, @RequestParam(value = "goodsId") String goodsId) {
        //仅管理员可用
        if (user.getUserType().equals(DataType.ADMIN)) {
            return shopCartManager.getShopCartByGoods(goodsId);
        }
        return Response.NOT_LOG_IN();
    }


    /**
     * 增加商品
     * @param user
     * @param shopCart
     * @return
     */
    @PostMapping("/addShopCart")
    public Response addShopCart(@DataAuth User user, @RequestBody ShopCart shopCart) {
        // 验证身份
        if (user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)) {
            return shopCartManager.addShopCart(shopCart);
        }
        return Response.NOT_LOG_IN();
    }

    /**
     * 通过用户和商品id删除
     * @param user
     * @param userId
     * @param goodsId
     * @return
     */
    @GetMapping("/deleteShopCartByUserAndGoodsId")
    public Response deleteShopCartByUserAndGoodsId(@DataAuth User user, @RequestParam("userId") String userId, @RequestParam("goodsId") String goodsId) {
        // 验证身份
        if (user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)) {
            return shopCartManager.deleteShopCartByUserAndGoodsId(userId, goodsId);
        }
        return Response.NOT_LOG_IN();
    }

    /**
     * 更新购物车
     * @param user
     * @param shopCart
     * @return
     */
    @PostMapping("/updateShopCart")
    public Response updateShopCart(@DataAuth User user, @RequestBody ShopCart shopCart){
        // 验证身份
        if (user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)) {
            return shopCartManager.updateShopCart(shopCart);
        }
        return Response.NOT_LOG_IN();

    }
}
