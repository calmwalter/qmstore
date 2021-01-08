package qmstore.payment_record.manager.impl;

import org.springframework.stereotype.Component;
import qmstore.payment_record.dao.PaymentRecordDao;
import qmstore.payment_record.manager.PaymentRecordManager;
import qmstore.payment_record.pojo.PaymentRecord;
import qmstore.util.Response;

import javax.annotation.Resource;

@Component
public class PaymentRecordManagerImpl implements PaymentRecordManager {
    @Resource
    PaymentRecordDao paymentRecordDao;

    @Override
    public Response selectByOrderId(String orderId) {
        try {
            return Response.SUCCESS(paymentRecordDao.selectByOrderId(orderId));
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @Override
    public Response deleteByOrderId(String orderId) {
        try {
            return Response.SUCCESS(paymentRecordDao.deleteByOrderId(orderId));
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @Override
    public Response insertPaymentRecord(PaymentRecord record) {
        try {
            return Response.SUCCESS(paymentRecordDao.insertPaymentRecord(record));
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @Override
    public Response updatePaymentRecord(PaymentRecord record) {
        try {
            return Response.SUCCESS(paymentRecordDao.updatePaymentRecord(record));
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @Override
    public Response getAllPaymentRecord() {
        try {
            return Response.SUCCESS(paymentRecordDao.getAllPaymentRecord());
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }


}
