package qmstore.order_detail.controller;

import org.springframework.web.bind.annotation.*;
import qmstore.order_detail.manager.impl.OrderDetailManagerImpl;
import qmstore.order_detail.pojo.OrderDetail;
import qmstore.user.annotation.DataAuth;
import qmstore.user.constant.DataType;
import qmstore.user.pojo.User;
import qmstore.util.Response;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order_state")
public class OrderStateController {
    @Resource
    OrderDetailManagerImpl orderDetailManager;

    /**
     *
     * @param user
     * @param orderId
     * @return
     */
    @GetMapping("deleteByOrderId")
    Response deleteByOrderId(@DataAuth User user, @RequestParam(value = "orderId") String orderId){
        try {
            if(user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)){
                return orderDetailManager.deleteByOrderId(orderId);
            }
            return Response.NOT_LOG_IN();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @PostMapping("insertOrderDetail")
    Response insertOrderDetail(@DataAuth User user, @RequestBody OrderDetail record){
        try {
            if(user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)){
                return orderDetailManager.insertOrderDetail(record);
            }
            return Response.NOT_LOG_IN();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @GetMapping("selectByOrderId")
    Response selectByOrderId(@DataAuth User user, @RequestParam(value = "orderId") String orderId){
        try {
            if(user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)){
                return orderDetailManager.selectByOrderId(orderId);
            }
            return Response.NOT_LOG_IN();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @PostMapping("updateOrderDetail")
    Response updateOrderDetail(@DataAuth User user, @RequestBody OrderDetail record){
        try {
            if(user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)){
                return orderDetailManager.updateOrderDetail(record);
            }
            return Response.NOT_LOG_IN();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @GetMapping("getAllOrderDetail")
    Response selectByOrderId(@DataAuth User user){
        try {
            if( user.getUserType().equals(DataType.ADMIN)){
                return orderDetailManager.getAllOrderDetail();
            }
            return Response.NOT_LOG_IN();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @GetMapping("getAlreadySale")
        Response getAlreadySale(@DataAuth User user, String goodsId){
            try {
                if( user.getUserType().equals(DataType.ADMIN) || user.getUserType().equals(DataType.CUSTOMER)){
                    return orderDetailManager.getAlreadySale(goodsId);
                }
                return Response.NOT_LOG_IN();
            }catch (Exception e){
                return Response.ERROR(e.getMessage());
            }
        }

    /**
     * 根据用户id返回订单号
     */
    @GetMapping("getAllOrderByUserId")
    Response getAllOrderByUserId(@DataAuth User user, String userId){
        try {
            if( user.getUserType().equals(DataType.ADMIN) || user.getUserType().equals(DataType.CUSTOMER)){
                return orderDetailManager.getAllOrderByUserId(userId);
            }
            return Response.NOT_LOG_IN();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }
}
