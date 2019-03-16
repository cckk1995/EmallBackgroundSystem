package com.emall.service.impl;

import com.emall.dao.OrderDOMapper;
import com.emall.dao.OrderItemDOMapper;
import com.emall.dataobject.OrderDO;
import com.emall.dataobject.OrderItemDO;
import com.emall.error.BusinessException;
import com.emall.error.EmBusinessError;
import com.emall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Autowired
    private OrderItemDOMapper orderItemDOMapper;

    /**
     * 获得所有订单信息
     * @return
     * @throws BusinessException
     */
    @Override
    public List<OrderDO> getAllOrder() throws BusinessException {
        List<OrderDO> list = null;
        try{
            list = orderDOMapper.getAllOrder();
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        return list;
    }

    /**
     * 获得订单详情（显示所有购买商品的信息）
     * @param orderId
     * @return
     * @throws BusinessException
     */
    @Override
    public List<OrderItemDO> getOrderDetail(String orderId) throws BusinessException {
        List<OrderItemDO> list = null;
        try{
            list = orderItemDOMapper.getOrderItemByOrderId(orderId);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        return list;
    }

    /**
     * 修改订单状态
     * @param orderId
     * @param status
     * @throws BusinessException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrderStatus(String orderId, int status) throws BusinessException {
        if(orderId==null||orderId.equals("")){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        try{
            OrderDO orderDO = orderDOMapper.selectByPrimaryKey(orderId);
            orderDO.setOrderStatus(status);
            orderDO.setUpdateTime(new Date());
            orderDOMapper.deleteByPrimaryKey(orderId);
            orderDOMapper.insert(orderDO);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     * 删除订单
     * @param orderId
     * @throws BusinessException
     */
    @Override
    public void deleteOrder(String orderId) throws BusinessException {
        if(orderId==null||orderId.equals("")){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        try{
            orderDOMapper.deleteByPrimaryKey(orderId);
            orderItemDOMapper.deleteByOrderId(orderId);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }
}
