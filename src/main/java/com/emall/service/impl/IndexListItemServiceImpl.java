package com.emall.service.impl;

import com.emall.controller.viewobject.IndexListItemVO;
import com.emall.dao.IndexListItemDOMapper;
import com.emall.dao.ItemDOMapper;
import com.emall.dao.ItemStockDOMapper;
import com.emall.dataobject.IndexListItemDO;
import com.emall.dataobject.ItemDO;
import com.emall.error.BusinessException;
import com.emall.error.EmBusinessError;
import com.emall.service.IndexListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("IndexListItemService")
public class IndexListItemServiceImpl implements IndexListItemService {

    @Autowired
    private IndexListItemDOMapper indexListItemDOMapper;

    @Autowired
    private ItemDOMapper itemDOMapper;

    @Autowired
    private ItemStockDOMapper itemStockDOMapper;


    /**
     * 获得所有的IndexListItemVO
     * @param listId
     * @return
     * @throws BusinessException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<IndexListItemVO> getAllIndexListItem(int listId) throws BusinessException {
        List<IndexListItemVO> indexListItemVOS = new ArrayList<>();
        List<IndexListItemDO> indexListItemDOS = null;
        try{
            indexListItemDOS = indexListItemDOMapper.getListItemByListId(listId);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        try{
            for(IndexListItemDO indexListItemDO : indexListItemDOS){
                indexListItemVOS.add(indexListItemDOTOIndexListItemVO(indexListItemDO));
            }
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        return indexListItemVOS;
    }

    /**
     * 修改首页导航列表商品
     * @param indexListItemDO
     * @throws BusinessException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyIndexListItem(IndexListItemDO indexListItemDO) throws BusinessException {
        String itemId = indexListItemDO.getItemId();
        try{
            indexListItemDOMapper.deleteByPrimaryKey(itemId);
            indexListItemDOMapper.insert(indexListItemDO);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    private IndexListItemVO indexListItemDOTOIndexListItemVO(IndexListItemDO indexListItemDO){
        String itemId  = indexListItemDO.getItemId();
        ItemDO itemDO = itemDOMapper.selectByPrimaryKey(itemId);
        IndexListItemVO indexListItemVO = new IndexListItemVO();
        indexListItemVO.setId(itemId);
        indexListItemVO.setDesc(indexListItemDO.getDesc());
        indexListItemVO.setDiscount(indexListItemDO.getDiscount());
        indexListItemDO.setDiscountType(indexListItemDO.getDiscountType());
        indexListItemVO.setSorted(indexListItemDO.getSorted());
        indexListItemVO.setSourceUrl(indexListItemDO.getSourceUrl());
        indexListItemVO.setOldPrice(indexListItemDO.getOldPrice());
        indexListItemVO.setImgUrl(itemDO.getItemMainImage());
        indexListItemVO.setTitle(itemDO.getItemTitle());
        indexListItemVO.setPrice(itemStockDOMapper.getMinPrice(itemId));
        return indexListItemVO;
    }
}
