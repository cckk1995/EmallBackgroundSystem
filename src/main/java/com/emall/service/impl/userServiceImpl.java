package com.emall.service.impl;

import com.emall.controller.viewobject.UserVO;
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

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class userServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    /**
     * 删除指定userId组的用户
     * @param idGroup  例如  id1,id2,id3
     * @throws BusinessException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUsers(String idGroup) throws BusinessException {
        if(idGroup==null||idGroup.equals("")){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        try{
            String[] userIdS = idGroup.split(",");
            for(String userId : userIdS) {
                userDOMapper.deleteByPrimaryKey(userId);
                userPasswordDOMapper.deleteByUserId(userId);
            }
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
    public void modifyUser(UserDO userDO, UserPasswordDO userPasswordDO) throws BusinessException {
        try{
            deleteUsers(userDO.getUserId());
            addUser(userDO,userPasswordDO);
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
    @Transactional(rollbackFor = Exception.class)
    public void addUser(UserDO userDO,UserPasswordDO userPasswordDO) throws BusinessException {
        if(userDO==null||userPasswordDO==null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        try{
            userDOMapper.insert(userDO);
            userPasswordDOMapper.insert(userPasswordDO);
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     * 获得所有的用户
     * @return
     * @throws BusinessException
     */
    @Override
    public List<UserVO> getUsers() throws BusinessException {
        List<UserVO> userVOS = new ArrayList<>();
        try{
            List<UserDO> userDOS = userDOMapper.getAllUser();
            for(UserDO userDO : userDOS){
                String userId = userDO.getUserId();
                UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userId);
                userVOS.add(new UserVO(userDO,userPasswordDO));
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        return userVOS;
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
