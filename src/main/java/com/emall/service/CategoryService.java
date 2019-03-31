package com.emall.service;

import com.emall.controller.viewobject.CategoryVO;
import com.emall.dataobject.CategoryDO;
import com.emall.error.BusinessException;

import java.util.List;

public interface CategoryService {
    List<CategoryDO> getAllCategory() throws BusinessException;
    List<CategoryVO> getAllCategoryVO() throws BusinessException;
    void addCategory(CategoryDO categoryDO) throws BusinessException;
    void deleteCategory(int catId) throws BusinessException;
    void deleteCategoryByName(String name) throws BusinessException;
}
