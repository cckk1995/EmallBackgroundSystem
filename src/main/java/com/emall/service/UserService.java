package com.emall.service;


import com.emall.controller.viewobject.UserVO;
import com.emall.dataobject.UserDO;
import com.emall.dataobject.UserPasswordDO;
import com.emall.error.BusinessException;

import java.util.List;

/**
 * created by cckk1995 on 2019/3/16
 */
public interface UserService {
    void deleteUsers(String idGroup) throws BusinessException;
    void modifyUser(UserDO userDO, UserPasswordDO userPasswordDO) throws BusinessException;
    void addUser(UserDO userDO,UserPasswordDO userPasswordDO) throws BusinessException;
    List<UserVO> getUsers() throws BusinessException;
    UserPasswordDO getPassword(String userId) throws  BusinessException;
}
