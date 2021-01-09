package qmstore.order_detail.dao;

import org.springframework.stereotype.Repository;
import qmstore.order_detail.pojo.OrderDetail;

import java.util.List;

@Repository
public interface OrderDetailDao {
    int deleteByOrderId(String orderId);

    int insertOrderDetail(OrderDetail record);

    OrderDetail selectByOrderId(String orderId);

    int updateOrderDetail(OrderDetail record);

    List<OrderDetail> getAllOrderDetail();

    List<OrderDetail> getAllOrderByGoodsId(String goodsId);

    int getAlreadySale(String goodsId);
}
