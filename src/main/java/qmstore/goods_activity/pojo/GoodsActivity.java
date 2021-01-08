package qmstore.goods_activity.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class GoodsActivity {
    int id;
    String goodsId;
    String activityId;
    Timestamp createTime;
    Timestamp updateTime;


}
