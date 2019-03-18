package com.emall.service;

import com.emall.dataobject.NavigationDO;
import com.emall.error.BusinessException;
import org.springframework.stereotype.Service;

@Service
public interface NavigationService {
    void uploadNavigation(NavigationDO navigationDO) throws BusinessException;
    void deleteNavigation(String id) throws BusinessException;
    void modifyNavigation(NavigationDO navigationDO) throws  BusinessException;
}
