package qmstore.payment_record.manager;

import qmstore.util.Response;

public interface PaymentRecordManager {
    public Response selectByOrderId(String orderId);
}
