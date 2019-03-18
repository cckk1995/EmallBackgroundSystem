package com.emall.dao;

import com.emall.dataobject.NavigationDO;
import org.springframework.stereotype.Component;

@Component
public interface NavigationDOMapper {

    int deleteByPrimaryKey(String id);

    int insert(NavigationDO record);

    int insertSelective(NavigationDO record);

    NavigationDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NavigationDO record);

    int updateByPrimaryKey(NavigationDO record);
}
