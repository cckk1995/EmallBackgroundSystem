package com.emall.service.impl;

import com.emall.controller.viewobject.OrderVO;
import com.emall.dao.OrderDOMapper;
import com.emall.dao.OrderItemDOMapper;
import com.emall.dao.UserDOMapper;
import com.emall.dataobject.OrderDO;
import com.emall.dataobject.OrderItemDO;
import com.emall.error.BusinessException;
import com.emall.error.EmBusinessError;
import com.emall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Autowired
    private OrderItemDOMapper orderItemDOMapper;

    @Autowired
    private UserDOMapper userDOMapper;

    /**
     * 获得所有订单信息
     * @return
     * @throws BusinessException
     */
    @Override
    public List<OrderVO> getAllOrder() throws BusinessException {
        List<OrderVO> orderVOS = new ArrayList<>();
        List<OrderDO> orderDOS = null;
        try{
            orderDOS = orderDOMapper.getAllOrder();
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        for(OrderDO orderDO : orderDOS){
            orderVOS.add(orderDOTOOrderVO(orderDO));
        }
        return orderVOS;
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
            orderDO.setEndTime(new Date());
            orderDOMapper.deleteByPrimaryKey(orderId);
            orderDOMapper.insert(orderDO);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     * 删除订单
     * @param idGroup
     * @throws BusinessException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOrder(String idGroup) throws BusinessException {
        String[] orderIdS = idGroup.split(",");
        try{
            for(String orderId : orderIdS) {
                orderDOMapper.deleteByPrimaryKey(orderId);
                orderItemDOMapper.deleteByOrderId(orderId);
            }
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    private OrderVO orderDOTOOrderVO(OrderDO orderDO) {
        String userId = orderDO.getUserId();
        OrderVO orderVO = new OrderVO();
        orderVO.setOrderId(orderDO.getOrderId());
        orderVO.setPayment(orderDO.getPayment());
        orderVO.setUserName(userDOMapper.getUserNameByUserId(userId));
        orderVO.setRemark("质量好，价格便宜");
        orderVO.setOrderStatus(orderDO.getOrderStatus());
        orderVO.setCloseDate(orderDO.getCloseTime());
        orderVO.setCreatedDate(orderDO.getCreateTime());
        orderVO.setPaymentDate(orderDO.getPaymentTime());
        orderVO.setEndDate(orderDO.getEndTime());
        return orderVO;
    }
}
