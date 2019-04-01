package com.emall.service.impl;

import com.emall.dao.OrderDOMapper;
import com.emall.dao.OrderItemDOMapper;
import com.emall.dataobject.OrderDO;
import com.emall.error.BusinessException;
import com.emall.error.EmBusinessError;
import com.emall.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("statisticService")
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Autowired
    private OrderItemDOMapper orderItemDOMapper;

    @Override
    public Map<String, float[]> getStatistics() throws BusinessException {
        float[] sales = new float[12];
        float[] items = new float[12];
        List<OrderDO> orderDOS = null;
        try{
            orderDOS = orderDOMapper.getAllOrder();
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        int yearNow = new Date().getYear();
        try{
            for(OrderDO orderDO : orderDOS){
                calculate(orderDO,sales,items,yearNow);
            }
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        Map<String,float[]> map = new HashMap<>();
        map.put("sales",sales);
        map.put("items",items);
        return map;
    }

    private void calculate(OrderDO orderDO,float[] Sales,float[] items,int yearNow){
        Date time = orderDO.getEndTime();
        if(time==null){
            return ;
        }
        int year = time.getYear();
        if(year != yearNow) {
            return ;
        }
        int month = time.getMonth();
        float payment = orderDO.getPayment().floatValue();
        Sales[month]+=payment;
        String orderId = orderDO.getOrderId();
        int amount = orderItemDOMapper.getAmountByOrderId(orderId);
        items[month]+=amount;
    }
}
