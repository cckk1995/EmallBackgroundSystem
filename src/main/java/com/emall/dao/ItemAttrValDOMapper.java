package com.emall.dao;

import com.emall.dataobject.ItemAttrValDO;
import org.springframework.stereotype.Component;

@Component
public interface ItemAttrValDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_item_attr_val
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int insert(ItemAttrValDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_item_attr_val
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int insertSelective(ItemAttrValDO record);
    int deleteByItemId(String itemId);
}