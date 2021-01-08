package qmstore.shop_cart.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ShopCart {
    private String userId;
    private String goodsId;
    private int goodsNum;
    private Timestamp createTime;
    private Timestamp updateTime;

}
