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

    @GetMapping("/getShopCartByUser")
    public Response getShopCartByUser(@DataAuth User user, @RequestParam(value = "userId") String userId) {
        // 验证身份
        if (user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)) {
            return shopCartManager.getShopCartByUser(userId);
        }
        return Response.NOT_LOG_IN();
    }

    @GetMapping("/getShopCartByGoods")
    public Response getShopCartByGoods(@DataAuth User user, @RequestParam(value = "goodsId") String goodsId) {
        //仅管理员可用
        if (user.getUserType().equals(DataType.ADMIN)) {
            return shopCartManager.getShopCartByGoods(goodsId);
        }
        return Response.NOT_LOG_IN();
    }


    @PostMapping("/addShopCart")
    public Response addShopCart(@DataAuth User user, @RequestBody ShopCart shopCart) {
        // 验证身份
        if (user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)) {
            return shopCartManager.addShopCart(shopCart);
        }
        return Response.NOT_LOG_IN();
    }

    @GetMapping("/deleteShopCartByUserAndGoodsId")
    public Response deleteShopCartByUserAndGoodsId(@DataAuth User user, @RequestParam("userId") String userId, @RequestParam("goodsId") String goodsId) {
        // 验证身份
        if (user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)) {
            return shopCartManager.deleteShopCartByUserAndGoodsId(userId, goodsId);
        }
        return Response.NOT_LOG_IN();
    }

    @PostMapping("/updateShopCart")
    public Response updateShopCart(@DataAuth User user, @RequestBody ShopCart shopCart){
        // 验证身份
        if (user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)) {
            return shopCartManager.updateShopCart(shopCart);
        }
        return Response.NOT_LOG_IN();

    }
}
