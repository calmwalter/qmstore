package qmstore.order_detail.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qmstore.order_detail.manager.impl.OrderDetailManagerImpl;
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


}
