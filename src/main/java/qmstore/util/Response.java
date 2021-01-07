package qmstore.util;

import lombok.Data;

@Data
public class Response<T> {
    private static final int CODE_SUCCESS = ResponseEnum.SUCCESS.getCode();

    private static final int CODE_ERROR = ResponseEnum.SYSTEM_ERROR.getCode();

    private static final int CODE_BUSY= ResponseEnum.SYSTEM_BUSY.getCode();

    private static final int CODE_NO_LOGIN = ResponseEnum.NOT_LOGIN_IN.getCode();

    private static final int CODE_FAIL = ResponseEnum.SYSTEM_FAIL.getCode();


    private int code;
    private String msg;
    private String error;
    private T data;

    public Response(int code, String msg, String error, T data){
        this.setCode(code);
        this.setMsg(msg);
        this.setError(error);
        this.setData(data);
    }

    public static <T> Response<T> SUCCESS() {return new Response<>(CODE_SUCCESS, ResponseEnum.SUCCESS.getValue(), null, null);}
    public static <T> Response<T> SUCCESS (T data) {return new Response<>(CODE_SUCCESS, ResponseEnum.SUCCESS.getValue(), null,data);}

    public static <T> Response<T> ERROR() {return new Response<>(CODE_ERROR,ResponseEnum.SYSTEM_ERROR.getValue(), null, null);}
    public static <T> Response<T> ERROR(String error) {return new Response<>(CODE_ERROR,ResponseEnum.SYSTEM_ERROR.getValue(), error, null);}

    public static <T> Response<T> NOT_LOG_IN() {return new Response<>(CODE_NO_LOGIN,ResponseEnum.NOT_LOGIN_IN.getValue(), null, null);}

    public static <T> Response<T> BUSY() {return new Response<>(CODE_BUSY,ResponseEnum.SYSTEM_ERROR.getValue(), null, null);}

    public static <T> Response<T> FAIL() {return new Response<>(CODE_FAIL,ResponseEnum.SYSTEM_FAIL.getValue(), null, null);}
    public static <T> Response<T> FAIL(String reason) {return new Response<>(CODE_FAIL,ResponseEnum.SYSTEM_FAIL.getValue(), reason, null);}




}
