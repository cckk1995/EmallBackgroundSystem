package com.emall.dao;

import com.emall.dataobject.AddressDO;

public interface AddressDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_address
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int deleteByPrimaryKey(String addressId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_address
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int insert(AddressDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_address
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int insertSelective(AddressDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_address
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    AddressDO selectByPrimaryKey(String addressId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_address
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int updateByPrimaryKeySelective(AddressDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_address
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    int updateByPrimaryKey(AddressDO record);
}