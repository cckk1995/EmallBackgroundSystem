package com.emall.service.impl;

import com.emall.dao.AdminDOMapper;
import com.emall.dataobject.AdminDO;
import com.emall.error.BusinessException;
import com.emall.error.EmBusinessError;
import com.emall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDOMapper adminDOMapper;

    /**
     * 获得所有的管理员信息
     * @return
     * @throws BusinessException
     */
    @Override
    public List<AdminDO> getAllAdmin() throws BusinessException {
        try{
            return adminDOMapper.getAllAdmin();
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     * 根据管理员的id删除管理员信息
     * @throws BusinessException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAdminByIdGroup(String idGroup) throws BusinessException {
        String[] ids = idGroup.split(",");
        try{
            for(String id : ids){
                adminDOMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     * 添加一个管理员用户
     * @param adminDO
     * @throws BusinessException
     */
    @Override
    public void addAdmin(AdminDO adminDO) throws BusinessException {
        try {
            adminDOMapper.insert(adminDO);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     * 删除一个管理员用户
     * @param adminDO
     * @throws BusinessException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyAdmin(AdminDO adminDO) throws BusinessException {
        try{
            String adminId = adminDO.getAdminId();
            adminDOMapper.deleteByPrimaryKey(adminId);
            adminDOMapper.insert(adminDO);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }
}
