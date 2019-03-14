package com.emall.dao;

import com.emall.dataobject.ItemDO;
import org.springframework.stereotype.Component;

@Component
public interface ItemDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_item
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int deleteByPrimaryKey(String itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_item
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int insert(ItemDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_item
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int insertSelective(ItemDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_item
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    ItemDO selectByPrimaryKey(String itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_item
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int updateByPrimaryKeySelective(ItemDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_item
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(ItemDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_item
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int updateByPrimaryKey(ItemDO record);
}