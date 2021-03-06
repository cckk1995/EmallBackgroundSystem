package com.emall.dao;

import com.emall.dataobject.IndexListDO;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface IndexListDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_index_list
     *
     * @mbg.generated Sat Mar 30 20:03:01 CST 2019
     */
    int deleteByPrimaryKey(Integer listId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_index_list
     *
     * @mbg.generated Sat Mar 30 20:03:01 CST 2019
     */
    int insert(IndexListDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_index_list
     *
     * @mbg.generated Sat Mar 30 20:03:01 CST 2019
     */
    int insertSelective(IndexListDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_index_list
     *
     * @mbg.generated Sat Mar 30 20:03:01 CST 2019
     */
    IndexListDO selectByPrimaryKey(Integer listId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_index_list
     *
     * @mbg.generated Sat Mar 30 20:03:01 CST 2019
     */
    int updateByPrimaryKeySelective(IndexListDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_index_list
     *
     * @mbg.generated Sat Mar 30 20:03:01 CST 2019
     */
    int updateByPrimaryKey(IndexListDO record);

    int modifyIndexList(Map<String,String> map);
}