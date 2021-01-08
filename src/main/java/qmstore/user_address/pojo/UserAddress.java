package qmstore.user_address.pojo;

import lombok.Data;

@Data
public class UserAddress {

    private String userId;

    private String address;

    private String userName;

    private String userPhone;

    private String addressId;

    /**
     * 邮编
     */
    private String zipCode;

}
