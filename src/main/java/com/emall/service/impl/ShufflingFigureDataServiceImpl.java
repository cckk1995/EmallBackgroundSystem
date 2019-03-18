package com.emall.service.impl;

import com.emall.dao.ShufflingFigureDataDOMapper;
import com.emall.dataobject.ShufflingFigureDataDO;
import com.emall.error.BusinessException;
import com.emall.error.EmBusinessError;
import com.emall.service.ShufflingFigureDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShufflingFigureDataServiceImpl implements ShufflingFigureDataService {

    @Autowired
    private ShufflingFigureDataDOMapper shufflingFigureDataDOMapper;

    @Override
    public void deleteShufflingFigureData(String shufflingId) throws BusinessException {
        try {
            shufflingFigureDataDOMapper.deleteByPrimaryKey(shufflingId);
        } catch (Exception e) {
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    @Override
    public void modifyShufflingFigureData(ShufflingFigureDataDO shufflingFigureDataDO) throws BusinessException {
        try {
            shufflingFigureDataDOMapper.updateByPrimaryKey(shufflingFigureDataDO);
        } catch (Exception e) {
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    @Override
    public void uploadShufflingFigureData(ShufflingFigureDataDO shufflingFigureDataDO) throws BusinessException {
        try {
            shufflingFigureDataDOMapper.insert(shufflingFigureDataDO);
        } catch (Exception e) {
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }
}
