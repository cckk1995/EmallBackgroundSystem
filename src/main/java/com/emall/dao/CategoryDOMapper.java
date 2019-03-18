package com.emall.dao;

import com.emall.dataobject.CategoryDO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_category
     *
     * @mbg.generated Fri Mar 15 16:14:48 CST 2019
     */
    int deleteByPrimaryKey(Integer catId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_category
     *
     * @mbg.generated Fri Mar 15 16:14:48 CST 2019
     */
    int insert(CategoryDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_category
     *
     * @mbg.generated Fri Mar 15 16:14:48 CST 2019
     */
    int insertSelective(CategoryDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_category
     *
     * @mbg.generated Fri Mar 15 16:14:48 CST 2019
     */
    CategoryDO selectByPrimaryKey(Integer catId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_category
     *
     * @mbg.generated Fri Mar 15 16:14:48 CST 2019
     */
    int updateByPrimaryKeySelective(CategoryDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_category
     *
     * @mbg.generated Fri Mar 15 16:14:48 CST 2019
     */
    int updateByPrimaryKey(CategoryDO record);

    List<CategoryDO> getAllCategory();
}