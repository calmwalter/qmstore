package qmstore.user_address.dao;

import org.apache.ibatis.annotations.Param;
import qmstore.user_address.pojo.UserAddress;

import java.util.List;

public interface UserAddressDao {
    int insertUserAddress(UserAddress userAddress);

    int deleteUserAddress(@Param("userId") String userId, @Param("addressId") String addressId);

    int updateUserAddress(UserAddress userAddress);

    List<UserAddress> selectUserAddressByUserId(String userId);

    UserAddress selectUserAddressByUserIdAndAddressId(@Param("userId") String userId, @Param("addressId") String addressId);


}
