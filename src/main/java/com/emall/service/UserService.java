package com.emall.service;


import com.emall.dataobject.UserDO;
import com.emall.dataobject.UserPasswordDO;
import com.emall.error.BusinessException;

import java.util.List;

/**
 * created by cckk1995 on 2019/3/16
 */
public interface UserService {
    void deleteUser(String userId) throws BusinessException;
    void modifyUser(UserDO userDO) throws BusinessException;
    void addUser(UserDO userDO) throws BusinessException;
    List<UserDO> getUsers() throws BusinessException;
    UserPasswordDO getPassword(String userId) throws  BusinessException;
}
