package com.emall.service.impl;

import com.emall.dao.UserDOMapper;
import com.emall.dao.UserPasswordDOMapper;
import com.emall.dataobject.UserDO;
import com.emall.dataobject.UserPasswordDO;
import com.emall.error.BusinessException;
import com.emall.error.EmBusinessError;
import com.emall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class userServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    /**
     * 删除指定userId的用户
     * @param userId
     * @throws BusinessException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(String userId) throws BusinessException {
        if(userId==null||userId.equals("")){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        try{
            userDOMapper.deleteByPrimaryKey(userId);
            userPasswordDOMapper.deleteByUserId(userId);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     *
     * 修改用户信息
     * @param userDO
     * @throws BusinessException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyUser(UserDO userDO) throws BusinessException {
        if(userDO==null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        String userId = userDO.getUserId();
        try{
            deleteUser(userId);
            addUser(userDO);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     * 添加一个用户
     * @param userDO
     * @throws BusinessException
     */
    @Override
    public void addUser(UserDO userDO) throws BusinessException {
        if(userDO==null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        try{
            userDOMapper.insert(userDO);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     * 获得所有的用户
     * @return
     * @throws BusinessException
     */
    @Override
    public List<UserDO> getUsers(int status) throws BusinessException {
        List<UserDO> list = null;
        try{
           list =  userDOMapper.getAllUser(status);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        return list;
    }

    /**
     * 获得指定userId的用户密码
     * @param userId
     * @return
     * @throws BusinessException
     */
    @Override
    public UserPasswordDO getPassword(String userId) throws BusinessException {
        UserPasswordDO userPasswordDO = null;
        if(userId==null||userId.equals("")){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        try{
            userPasswordDO = userPasswordDOMapper.selectByUserId(userId);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        return userPasswordDO;
    }
}
