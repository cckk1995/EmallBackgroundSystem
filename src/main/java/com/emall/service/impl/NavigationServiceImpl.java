package com.emall.service.impl;

import com.emall.dao.NavigationDOMapper;
import com.emall.dataobject.NavigationDO;
import com.emall.error.BusinessException;
import com.emall.error.EmBusinessError;
import com.emall.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavigationServiceImpl implements NavigationService {
    @Autowired
    private NavigationDOMapper navigationDOMapper;

    /**
     *
     * @param id
     * @throws BusinessException
     */
    @Override
    public void deleteNavigation(String id) throws BusinessException {
        try{
            navigationDOMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     *
     * @param navigationDO
     * @throws BusinessException
     */
    @Override
    public void uploadNavigation(NavigationDO navigationDO) throws BusinessException {
        try{
            navigationDOMapper.insert(navigationDO);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     *
     * @param navigationDO
     * @throws BusinessException
     */
    @Override
    public void modifyNavigation(NavigationDO navigationDO) throws BusinessException {
        try{
            navigationDOMapper.updateByPrimaryKey(navigationDO);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }
}
