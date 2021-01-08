package qmstore.order_detail.manager.impl;

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
        
        return null;
    }

    @Override
    public Response insertOrderDetail(OrderDetail record) {
        return null;
    }

    @Override
    public Response selectByOrderId(String orderId) {
        return null;
    }

    @Override
    public Response updateOrderDetail(OrderDetail record) {
        return null;
    }

    @Override
    public Response getAllOrderDetail() {
        return null;
    }
}
