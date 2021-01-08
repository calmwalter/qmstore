package qmstore.order_detail.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderDetail implements Serializable {
    private String orderId;

    private String userId;

    private String goodsId;

    /**
     * 物流编码
     */
    private String logisticsId;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 商品单价
     */
    private Double goodsPrice;

    /**
     * 商品总价
     */
    private Double goodsAmount;

    /**
     * 订单描述
     */
    private String orderDesc;

    private String orderStateCode;

    private String orderStateDesc;

    private Date createTime;

    private Date updateTime;

    private String address;


}