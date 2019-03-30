package com.emall.service;

import com.emall.controller.viewobject.OrderVO;
import com.emall.dataobject.OrderItemDO;
import com.emall.error.BusinessException;

import java.util.List;

public interface OrderService {
    List<OrderVO> getAllOrder() throws BusinessException;
    List<OrderItemDO> getOrderDetail(String orderId) throws BusinessException;
    void updateOrderStatus(String orderId,int status) throws BusinessException;
    void deleteOrder(String orderId) throws BusinessException;
}
