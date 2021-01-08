package qmstore.activity_category.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ActivityCategory {
    int id;
    String activityId;
    String activityName;
    String category;
    Timestamp startTime;
    Timestamp endTime;
    Timestamp createTime;
    Timestamp updateTime;
    String activityDesc;


}
