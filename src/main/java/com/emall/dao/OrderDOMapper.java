package com.emall.dao;

import com.emall.dataobject.OrderDO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface OrderDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_order
     *
     * @mbg.generated Sat Mar 30 15:21:59 CST 2019
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_order
     *
     * @mbg.generated Sat Mar 30 15:21:59 CST 2019
     */
    int insert(OrderDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_order
     *
     * @mbg.generated Sat Mar 30 15:21:59 CST 2019
     */
    int insertSelective(OrderDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_order
     *
     * @mbg.generated Sat Mar 30 15:21:59 CST 2019
     */
    OrderDO selectByPrimaryKey(String orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_order
     *
     * @mbg.generated Sat Mar 30 15:21:59 CST 2019
     */
    int updateByPrimaryKeySelective(OrderDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_order
     *
     * @mbg.generated Sat Mar 30 15:21:59 CST 2019
     */
    int updateByPrimaryKey(OrderDO record);

    List<OrderDO> getAllOrder();

    int updateOrderStatus(Map<String,String> map);
}