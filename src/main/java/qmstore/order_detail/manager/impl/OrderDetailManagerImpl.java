package qmstore.order_detail.manager.impl;

import qmstore.order_detail.constant.OrderStateEnum;
import qmstore.order_detail.dao.OrderDetailDao;
import qmstore.order_detail.manager.OrderDetailManager;
import qmstore.order_detail.pojo.OrderDetail;
import qmstore.util.Response;

import javax.annotation.Resource;

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
            if(record != null && (record.getOrderStateCode() == null || record.getOrderStateCode().equals(""))){
                record.setOrderStateCode(OrderStateEnum.UNPAID.getOrderStateCode());
                record.setOrderStateDesc(OrderStateEnum.UNPAID.getOrderStateDesc());
            }
            return Response.SUCCESS(orderDetailDao.insertOrderDetail(record));
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
}
