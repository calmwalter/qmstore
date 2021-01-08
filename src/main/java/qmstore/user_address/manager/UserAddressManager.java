package qmstore.user_address.manager;

import qmstore.user_address.pojo.UserAddress;
import qmstore.util.Response;

import java.util.List;

public interface UserAddressManager {
    Response insertUserAddress(UserAddress userAddress);

    Response deleteUserAddress( String userId,  String addressId);

    Response updateUserAddress(UserAddress userAddress);

    Response selectUserAddressByUserId(String userId);

    Response selectUserAddressByUserIdAndAddressId( String userId,  String addressId);

}
