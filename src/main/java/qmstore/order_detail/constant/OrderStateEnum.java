package qmstore.order_detail.constant;


public enum OrderStateEnum {
    PAY_FAIL("01", "pay_fail"),
    UNPAID("02", "unpaid"),
    PAID_UNFINISHED("03", "paid_unfinished"),
    FINISHED("04", "finished")
    ;

    private String orderStateCode;
    private String orderStateDesc;
    OrderStateEnum(String orderStateCode, String orderStateDesc){
        this.orderStateCode = orderStateCode;
        this.orderStateDesc = orderStateDesc;
    }


}
