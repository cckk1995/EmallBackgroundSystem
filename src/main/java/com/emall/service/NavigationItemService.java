package com.emall.service;

import com.emall.controller.viewobject.NavigationItemVO;
import com.emall.dataobject.NavigationItemDO;
import com.emall.error.BusinessException;

import java.util.List;

public interface NavigationItemService {
    void addNavigationItem(NavigationItemDO navigationItemDO) throws BusinessException;
    List<NavigationItemVO> getAllNavigationItem() throws BusinessException;
    void deleteNavigationItem(String itemId) throws BusinessException;
}
