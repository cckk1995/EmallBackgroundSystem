package com.emall.service.impl;

import com.emall.dao.IndexListDOMapper;
import com.emall.dataobject.IndexListDO;
import com.emall.error.BusinessException;
import com.emall.error.EmBusinessError;
import com.emall.service.IndexListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("IndexListService")
public class IndexListServiceImpl implements IndexListService {

    @Autowired
    private IndexListDOMapper indexListDOMapper;

    /**
     * 更新导航列表的sourceUrl和imgUrl
     * @param listId
     * @param sourceUrl
     * @param imgUrl
     * @throws BusinessException
     */
    @Override
    public void modifyIndexList(int listId, String sourceUrl, String imgUrl) throws BusinessException {
        Map<String,String> map = new HashMap<>();
        map.put("listId",String.valueOf(listId));
        map.put("sourceUrl",sourceUrl);
        map.put("imgUrl",imgUrl);
        try{
            indexListDOMapper.modifyIndexList(map);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    @Override
    public IndexListDO getIndexList(int listId) throws BusinessException {
        IndexListDO indexListDO = null;
        try{
            indexListDO =  indexListDOMapper.selectByPrimaryKey(listId);
        }catch (Exception e){
           throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        return indexListDO;
    }
}
