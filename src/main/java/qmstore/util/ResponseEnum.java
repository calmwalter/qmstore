package qmstore.util;

import lombok.Data;

public enum ResponseEnum {
    SUCCESS(200, "成功"),
    NOT_LOGIN_IN(300, "未登录"),
    SYSTEM_BUSY(400, "系统繁忙"),
    SYSTEM_ERROR(500, "系统出错"),
    SYSTEM_FAIL(600, "访问出错")

    ;
    private final int code;
    private final String value;

    ResponseEnum(int code, String value){this.code = code; this.value=value;}
    public int getCode(){return code;}
    public String getValue(){return value;}

}
