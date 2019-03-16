package com.emall.service.impl;

import com.emall.dao.*;
import com.emall.dataobject.*;
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

    @Autowired
    private CategoryDOMapper categoryDOMapper;


    @Override
    public List<ItemDO> getItems() throws BusinessException {
        List<ItemDO> list = null;
        try{
            list = itemDOMapper.getAllItems();
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        return list;
    }

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

    @Override
    public void modifyItem(ItemDO item, List<ItemAttrKeyDO> itemAttrKeyDOS, List<ItemAttrValDO> itemAttrValDOS, List<ItemStockDO> itemStockDOS) throws BusinessException {
        if(item==null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        String itemId = item.getItemId();
        try{
            deleteItem(itemId);
            uploadItem(item,itemAttrKeyDOS,itemAttrValDOS,itemStockDOS);
        }catch (BusinessException e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     *
     * @param itemId
     * @throws BusinessException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteItem(String itemId) throws BusinessException {
        if(itemId==null||itemId.equals("")){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        try{
            itemDOMapper.deleteByPrimaryKey(itemId);
            itemAttrKeyDOMapper.deleteByItemId(itemId);
            itemAttrValDOMapper.deleteByItemId(itemId);
            itemStockDOMapper.deleteByItemId(itemId);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     * 返回所有的分类信息
     * @return
     * @throws BusinessException
     */
    @Override
    public List<CategoryDO> getAllCategory() throws BusinessException{
        List<CategoryDO> list = null;
        try{
            list = categoryDOMapper.getAllCategory();
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        return list;
    }

    /**
     * 添加商品的分类
     * @param categoryDO
     * @throws BusinessException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void uploadCategory(CategoryDO categoryDO) throws BusinessException {
        try{
            categoryDOMapper.insert(categoryDO);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     *
     * @param categoryDO
     * @throws BusinessException
     */
    @Override
    public void modifyCategory(CategoryDO categoryDO) throws BusinessException {
        try{
            categoryDOMapper.updateByPrimaryKey(categoryDO);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    @Override
    public void deleteCategory(int catId) throws BusinessException {
        try {
            categoryDOMapper.deleteByPrimaryKey(catId);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }
}
