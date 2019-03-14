package com.emall.service.impl;

import com.emall.dao.ItemAttrKeyDOMapper;
import com.emall.dao.ItemAttrValDOMapper;
import com.emall.dao.ItemDOMapper;
import com.emall.dao.ItemStockDOMapper;
import com.emall.dataobject.ItemAttrKeyDO;
import com.emall.dataobject.ItemAttrValDO;
import com.emall.dataobject.ItemDO;
import com.emall.dataobject.ItemStockDO;
import com.emall.error.BusinessException;
import com.emall.error.EmBusinessError;
import com.emall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDOMapper itemDOMapper;

    @Autowired
    private ItemAttrKeyDOMapper itemAttrKeyDOMapper;

    @Autowired
    private ItemAttrValDOMapper itemAttrValDOMapper;

    @Autowired
    private ItemStockDOMapper itemStockDOMapper;

    /**
     *
     * @param item
     * @param itemAttrKeyDOS
     * @param itemAttrValDOS
     * @param itemStockDOS
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void uploadItem(ItemDO item, List<ItemAttrKeyDO> itemAttrKeyDOS, List<ItemAttrValDO> itemAttrValDOS, List<ItemStockDO> itemStockDOS) throws BusinessException {
        if(item==null||itemAttrKeyDOS.size()==0||itemAttrValDOS.size()==0||itemStockDOS.size()==0){
           throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        try {
            itemDOMapper.insert(item);
            for(ItemAttrKeyDO itemAttrKeyDO : itemAttrKeyDOS){
                itemAttrKeyDOMapper.insert(itemAttrKeyDO);
            }
            for(ItemAttrValDO itemAttrValDO : itemAttrValDOS){
                itemAttrValDOMapper.insert(itemAttrValDO);
            }
            for(ItemStockDO itemStockDO : itemStockDOS){
                itemStockDOMapper.insert(itemStockDO);
            }
        }catch(Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }
}
