package com.emall.service.impl;

import com.emall.dao.CategoryDOMapper;
import com.emall.dataobject.CategoryDO;
import com.emall.error.BusinessException;
import com.emall.error.EmBusinessError;
import com.emall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDOMapper categoryDOMapper;

    /**
     * 获得所有的分类信息
     * @return
     * @throws BusinessException
     */
    @Override
    public List<CategoryDO> getAllCategory() throws BusinessException {
        try{
            return categoryDOMapper.getAllCategory();
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     * 添加
     * @throws BusinessException
     */
    @Override
    public void addCategory(CategoryDO categoryDO) throws BusinessException {
        try{
            categoryDOMapper.insert(categoryDO);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     * 根据catId删除分类信息
     * @param catId
     * @throws BusinessException
     */
    @Override
    public void deleteCategory(int catId) throws BusinessException {
        try{
            categoryDOMapper.deleteByPrimaryKey(catId);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }
}
