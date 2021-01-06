package qmstore.util;

public class Response {
    private static final int CODE_SUCCESS = ResponseEnum.SUCCESS.getCode();

    private static final int CODE_ERROR = ResponseEnum.SYSTEM_ERROR.getCode();

    private static final int CODE_BUSY= ResponseEnum.SYSTEM_BUSY.getCode();

    private static final int CODE_NO_LOGIN = ResponseEnum.NOT_LOGIN_IN.getCode();

}
