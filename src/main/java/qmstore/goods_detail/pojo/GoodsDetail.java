package qmstore.goods_detail.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class GoodsDetail {
    int id;
    String goodsId;
    String goodsName;
    String goodsCategoryCode;
    String goodsCategoryName;
    double goodsPrice;
    double goodsDiscount;
    String briefDesc;
    String detailDesc;
    String picUrl;
    Timestamp createTime;
    Timestamp updateTime;
    int saleStatus;


}
