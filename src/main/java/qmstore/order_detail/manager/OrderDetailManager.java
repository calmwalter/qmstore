package qmstore.order_detail.manager;

import qmstore.order_detail.dao.OrderDetailDao;
import qmstore.order_detail.pojo.OrderDetail;
import qmstore.util.Response;

import javax.annotation.Resource;
import java.util.List;

public interface OrderDetailManager {
    Response deleteByOrderId(String orderId);

    Response insertOrderDetail(OrderDetail record);

    Response selectByOrderId(String orderId);

    Response updateOrderDetail(OrderDetail record);

    Response getAllOrderDetail();

    Response getAlreadySale(String goodsId);
}