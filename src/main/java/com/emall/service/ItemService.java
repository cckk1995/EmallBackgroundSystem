package com.emall.service;

import com.emall.controller.viewobject.ItemVO;
import com.emall.dataobject.*;
import com.emall.error.BusinessException;

import java.util.List;
import java.util.Map;

/**
 *  created by cckk1995 on 2019/3/14
 */
public interface ItemService {
    List<ItemDO> getItems() throws BusinessException;
    void uploadItem(ItemDO item, List<ItemAttrKeyDO> itemAttrKeyDOS, List<ItemAttrValDO> itemAttrValDOS, List<ItemStockDO> itemStockDOS) throws BusinessException;
    void modifyItem(ItemDO item, List<ItemAttrKeyDO> itemAttrKeyDOS, List<ItemAttrValDO> itemAttrValDOS, List<ItemStockDO> itemStockDOS) throws BusinessException;
    void deleteItem(String itemId) throws BusinessException;
    List<CategoryDO> getAllCategory() throws BusinessException;
    void uploadCategory(CategoryDO categoryDO) throws BusinessException;
    void modifyCategory(CategoryDO categoryDO) throws BusinessException;
    void deleteCategory(int catId) throws BusinessException;
    List<ItemVO> getItemVOByCatId(int catId) throws BusinessException;
    Map<String,Object> getItemDetail(String itemId) throws BusinessException;
}
