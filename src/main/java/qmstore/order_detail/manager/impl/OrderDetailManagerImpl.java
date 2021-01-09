package qmstore.order_detail.manager.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import org.springframework.stereotype.Component;
import qmstore.order_detail.constant.OrderStateEnum;
import qmstore.order_detail.dao.OrderDetailDao;
import qmstore.order_detail.manager.OrderDetailManager;
import qmstore.order_detail.pojo.OrderDetail;
import qmstore.util.Response;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Component
public class OrderDetailManagerImpl implements OrderDetailManager {
    @Resource
    OrderDetailDao orderDetailDao;

    @Override
    public Response deleteByOrderId(String orderId) {
        try {
            return Response.SUCCESS(orderDetailDao.deleteByOrderId(orderId));
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    /**
     * 生成订单
     * 默认状态是未支付
     * @see qmstore.order_detail.constant.OrderStateEnum
     * @param record
     * @return
     */
    @Override
    public Response insertOrderDetail(OrderDetail record) {
        try {
            //检查价格
            if(record.getGoodsAmount() == null || record.getGoodsAmount() == 0){
                if(record.getGoodsPrice() != null && record.getGoodsPrice() != 0 &&
                record.getGoodsNum() != null && record.getGoodsNum() != 0) {
                    record.setGoodsAmount(record.getGoodsPrice() * record.getGoodsNum());
                }else {
                    return Response.FAIL("商品数量或单价有误");
                }
            }else {
                if(record.getGoodsPrice() != null && record.getGoodsPrice() != 0 &&
                        record.getGoodsNum() != null && record.getGoodsNum() != 0){
                    if(record.getGoodsAmount() != record.getGoodsPrice() * record.getGoodsNum()){
                        return Response.FAIL("商品总价有误");
                    }
                }
            }

            if(record != null && (record.getOrderStateCode() == null || record.getOrderStateCode().equals(""))){
                record.setOrderStateCode(OrderStateEnum.UNPAID.getOrderStateCode());
                record.setOrderStateDesc(OrderStateEnum.UNPAID.getOrderStateDesc());
            }
            record.setCreateTime(new Timestamp(System.currentTimeMillis()));
            record.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            record.setOrderId(IdUtil.simpleUUID());
            orderDetailDao.insertOrderDetail(record);
            return Response.SUCCESS(record);
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @Override
    public Response selectByOrderId(String orderId) {
        try {
            return Response.SUCCESS(orderDetailDao.selectByOrderId(orderId));
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @Override
    public Response updateOrderDetail(OrderDetail record) {
        try {
            return Response.SUCCESS(orderDetailDao.updateOrderDetail(record));
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @Override
    public Response getAllOrderDetail() {
        try{
            return Response.SUCCESS(orderDetailDao.getAllOrderDetail());
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }
    }

    @Override
    public Response getAlreadySale(String goodsId) {
        try{
            return Response.SUCCESS(orderDetailDao.getAlreadySale(goodsId));
        }catch (Exception e){
            return Response.ERROR(e.getMessage());
        }    }
}
