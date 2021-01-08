package qmstore.banner_goods.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BannerGoods {
    int id;
    String goodsId;
    String picUrl;
    Timestamp createTime;
    Timestamp updateTime;


}
