package com.emall.service;

import com.emall.dataobject.AdminDO;
import com.emall.error.BusinessException;

import java.util.List;

/**
 * created by cckk1995 on 2019/3/29
 */
public interface AdminService {
    List<AdminDO> getAllAdmin() throws BusinessException;
    void deleteAdminByIdGroup(String idGroup) throws BusinessException;
    void addAdmin(AdminDO adminDO) throws BusinessException;
    void modifyAdmin(AdminDO adminDO) throws BusinessException;
    String getPassword(String userName) throws BusinessException;
}
