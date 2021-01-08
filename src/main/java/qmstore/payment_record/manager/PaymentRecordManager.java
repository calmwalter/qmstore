package qmstore.payment_record.manager;

import qmstore.payment_record.pojo.PaymentRecord;
import qmstore.util.Response;

public interface PaymentRecordManager {
    public Response selectByOrderId(String orderId);
    public Response deleteByOrderId(String orderId);
    public Response insertPaymentRecord(PaymentRecord record);
    public Response updatePaymentRecord(PaymentRecord record);
    public Response getAllPaymentRecord();

}
