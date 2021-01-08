package qmstore.payment_record.dao;

import org.springframework.stereotype.Repository;
import qmstore.payment_record.pojo.PaymentRecord;

import java.util.List;

@Repository
public interface PaymentRecordDao {

    int deleteByOrderId(String orderId);

    int insertPaymentRecord(PaymentRecord record);

    PaymentRecord selectByOrderId(String orderId);

    int updatePaymentRecord(PaymentRecord record);

    List<PaymentRecord> getAllPaymentRecord();

}
