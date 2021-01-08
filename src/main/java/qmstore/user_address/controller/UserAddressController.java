package qmstore.user_address.controller;

import org.springframework.web.bind.annotation.*;
import qmstore.user.annotation.DataAuth;
import qmstore.user.constant.DataType;
import qmstore.user.pojo.User;
import qmstore.user_address.manager.impl.UserAddressManagerImpl;
import qmstore.user_address.pojo.UserAddress;
import qmstore.util.Response;

import javax.annotation.Resource;

@RestController
@RequestMapping("user_address")
public class UserAddressController {
    @Resource
    UserAddressManagerImpl userAddressManager;

    /**
     * 插入新地址
     * @param user
     * @param userAddress
     * @return
     */
    @PostMapping("insertUserAddress")
    Response insertUserAddress(@DataAuth User user, @RequestBody UserAddress userAddress){
        try {
            if(user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)){
                return userAddressManager.insertUserAddress(userAddress);
            }
            return Response.NOT_LOG_IN();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    /**
     * 根据用户和地址id删除地址
     * @param user
     * @param userId
     * @param addressId
     * @return
     */

    @GetMapping("deleteUserAddress")
    Response deleteUserAddress(@DataAuth User user, @RequestParam("userId") String userId, @RequestParam("addressId") String addressId) {
        try {
            if(user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)){
                return userAddressManager.deleteUserAddress(userId, addressId);
            }
            return Response.NOT_LOG_IN();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    /**
     * 更新地址信息
     * @param user
     * @param userAddress
     * @return
     */
    @PostMapping("updateUserAddress")
    Response updateUserAddress(@DataAuth User user, @RequestBody UserAddress userAddress){
        try {
            if(user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)){
                return userAddressManager.updateUserAddress(userAddress);
            }
            return Response.NOT_LOG_IN();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    /**
     * 根据userId查找所有地址
     * @param user
     * @param userId
     * @return
     */
    @PostMapping("selectUserAddressByUserId")
    Response selectUserAddressByUserId(@DataAuth User user, @RequestParam("userId") String userId){
        try {
            if(user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)){
                return userAddressManager.selectUserAddressByUserId(userId);
            }
            return Response.NOT_LOG_IN();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }


    /**
     * 根据userId addressId 查找地址
     * @param user
     * @param userId
     * @param addressId
     * @return
     */
    @PostMapping("selectUserAddressByUserIdAndAddressId")
    Response selectUserAddressByUserIdAndAddressId(@DataAuth User user, @RequestParam("userId") String userId, @RequestParam("addressId") String addressId){
        try {
            if(user.getUserType().equals(DataType.CUSTOMER) || user.getUserType().equals(DataType.ADMIN)){
                return userAddressManager.selectUserAddressByUserIdAndAddressId(userId, addressId);
            }
            return Response.NOT_LOG_IN();
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

}
