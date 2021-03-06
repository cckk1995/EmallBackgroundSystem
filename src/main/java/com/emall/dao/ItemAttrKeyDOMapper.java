package com.emall.dao;

import com.emall.dataobject.ItemAttrKeyDO;
import org.springframework.stereotype.Component;

@Component
public interface ItemAttrKeyDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_item_attr_key
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int deleteByPrimaryKey(Integer attrKeyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_item_attr_key
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int insert(ItemAttrKeyDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_item_attr_key
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int insertSelective(ItemAttrKeyDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_item_attr_key
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    ItemAttrKeyDO selectByPrimaryKey(Integer attrKeyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_item_attr_key
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int updateByPrimaryKeySelective(ItemAttrKeyDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_item_attr_key
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int updateByPrimaryKey(ItemAttrKeyDO record);

    int deleteByItemId(String itemId);
}