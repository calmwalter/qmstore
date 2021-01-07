package qmstore.user.pojo;

import cn.hutool.core.date.DateUtil;
import lombok.Data;
import qmstore.user.constant.DataType;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class User {
    private String userId;
    private String userGroup;
    private String password;
    private String phone;
    private String email;
    private DataType userType;
    //时间戳
    private Timestamp createTime;
    private Timestamp updateTime;
    //Date类型
    private Date createDate;
    private Date updateDate;


    public void test(){
        createDate = DateUtil.date(createDate.getTime());
        updateDate = DateUtil.date(updateDate.getTime());
        int year = DateUtil.year(createDate);
        int month = DateUtil.month(createDate);
        int day = DateUtil.dayOfMonth(createDate);

    }

}
