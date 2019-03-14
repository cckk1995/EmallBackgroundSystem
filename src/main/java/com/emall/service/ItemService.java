package com.emall.service;

import com.emall.dataobject.ItemAttrKeyDO;
import com.emall.dataobject.ItemAttrValDO;
import com.emall.dataobject.ItemDO;
import com.emall.dataobject.ItemStockDO;
import com.emall.error.BusinessException;

import java.util.List;

/**
 *  created by cckk1995 on 2019/3/14
 */
public interface ItemService {
    public void uploadItem(ItemDO item, List<ItemAttrKeyDO> itemAttrKeyDOS, List<ItemAttrValDO> itemAttrValDOS, List<ItemStockDO> itemStockDOS) throws BusinessException;
}
