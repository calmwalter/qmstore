package qmstore.payment_record.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentRecord {
    private String orderId;

    /**
     * 支付金额
     */
    private Double paymentAmount;

    /**
     * 支付状态
     */
    private String paymentState;

    /**
     * 支付方式
     */
    private String paymentWay;

    /**
     * 支付订单返回id 如 支付宝订单id
     */
    private String paymentId;

    private Date createTime;

    private Date updateTime;

    private String paymentStateCode;

    private String paymentStateDesc;

}
