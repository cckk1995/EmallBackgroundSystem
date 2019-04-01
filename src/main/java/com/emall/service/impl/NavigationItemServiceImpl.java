package com.emall.service.impl;

import com.emall.controller.viewobject.CategoryVO;
import com.emall.controller.viewobject.NavigationItemVO;
import com.emall.dao.ItemDOMapper;
import com.emall.dao.NavigationItemDOMapper;
import com.emall.dataobject.ItemDO;
import com.emall.dataobject.NavigationItemDO;
import com.emall.error.BusinessException;
import com.emall.error.EmBusinessError;
import com.emall.service.CategoryService;
import com.emall.service.NavigationItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("NavigationItemService")
public class NavigationItemServiceImpl implements NavigationItemService {

    @Autowired
    private NavigationItemDOMapper navigationItemDOMapper;

    @Autowired
    private ItemDOMapper itemDOMapper;

    @Autowired
    private CategoryService categoryService;

    @Override
    public void addNavigationItem(NavigationItemDO navigationItemDO) throws BusinessException {
        try{
            navigationItemDOMapper.insert(navigationItemDO);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    @Override
    public List<NavigationItemVO> getAllNavigationItem() throws BusinessException {
        Map<Integer,String> map = new HashMap<>();
        try{
            List<CategoryVO> list = categoryService.getAllCategoryVO();
            for(CategoryVO categoryVO : list){
                map.put(categoryVO.getCategoryId(),categoryVO.getCategoryName());
            }
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        List<NavigationItemVO> navigationItemVOS = new ArrayList<>();
        List<NavigationItemDO> navigationItemDOS = null;
        try{
            navigationItemDOS = navigationItemDOMapper.getAllNavigationItem();
            for(NavigationItemDO navigationItemDO : navigationItemDOS){
                navigationItemVOS.add(navigationItemDOTONavigationVO(navigationItemDO,map));
            }
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        return navigationItemVOS;
    }

    @Override
    public void deleteNavigationItem(String itemId) throws BusinessException {
        try{
            navigationItemDOMapper.deleteByItemId(itemId);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    private NavigationItemVO navigationItemDOTONavigationVO(NavigationItemDO navigationItemDO, Map<Integer,String> map){
        String itemId = navigationItemDO.getItemId();
        ItemDO itemDO = itemDOMapper.getByItemId(itemId);
        int catId = Integer.valueOf(itemDO.getCategoryId());
        NavigationItemVO navigationItemVO = new NavigationItemVO();
        navigationItemVO.setId(itemId);
        navigationItemVO.setImgUrl(itemDO.getItemMainImage());
        navigationItemVO.setBuyStatus(navigationItemDO.getItemStatus());
        navigationItemVO.setSourceUrl(navigationItemDO.getSourceUrl());
        navigationItemVO.setClassify(map.get(catId));
        navigationItemVO.setName(itemDO.getItemTitle());
        return navigationItemVO;
    }
}
