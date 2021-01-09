package qmstore.payment_record.controller;

import org.springframework.web.bind.annotation.*;
import qmstore.payment_record.manager.impl.PaymentRecordManagerImpl;
import qmstore.payment_record.pojo.PaymentRecord;
import qmstore.user.annotation.DataAuth;
import qmstore.user.constant.DataType;
import qmstore.user.pojo.User;
import qmstore.util.Response;

import javax.annotation.Resource;
@CrossOrigin(origins = "http://localhost:9528",allowCredentials = "true")
@RestController
@RequestMapping("payment_record")
public class PaymentRecordController {
    @Resource
    PaymentRecordManagerImpl paymentRecordManager;

    /**
     * 获取订单信息
     * @param user
     * @param orderId
     * @return
     */
    @GetMapping("selectByOrderId")
    Response selectByOrderId(@DataAuth User user, @RequestParam(value = "orderId") String orderId){
        try {
            if(user.getUserType().equals(DataType.ADMIN) || user.getUserType().equals(DataType.CUSTOMER)){
                return paymentRecordManager.selectByOrderId(orderId);
            }
            return Response.NOT_LOG_IN();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @GetMapping("deleteByOrderId")
    Response deleteByOrderId(@DataAuth User user, @RequestParam(value = "orderId") String orderId){
        try {
            if(user.getUserType().equals(DataType.ADMIN) || user.getUserType().equals(DataType.CUSTOMER)){
                return paymentRecordManager.deleteByOrderId(orderId);
            }
            return Response.NOT_LOG_IN();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @PostMapping("insertPaymentRecord")
    Response insertPaymentRecord(@DataAuth User user, @RequestBody PaymentRecord record){
        try {
            if(user.getUserType().equals(DataType.ADMIN) || user.getUserType().equals(DataType.CUSTOMER)){
                return paymentRecordManager.insertPaymentRecord(record);
            }
            return Response.NOT_LOG_IN();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @PostMapping("updatePaymentRecord")
    Response updatePaymentRecord(@DataAuth User user, @RequestBody PaymentRecord record){
        try {
            if(user.getUserType().equals(DataType.ADMIN) || user.getUserType().equals(DataType.CUSTOMER)){
                return paymentRecordManager.updatePaymentRecord(record);
            }
            return Response.NOT_LOG_IN();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @GetMapping("getAllPaymentRecord")
    Response getAllPaymentRecord(@DataAuth User user){
        try {
            if(user.getUserType().equals(DataType.ADMIN) ){
                return paymentRecordManager.getAllPaymentRecord();
            }
            return Response.FAIL("权限不足");
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }



}
