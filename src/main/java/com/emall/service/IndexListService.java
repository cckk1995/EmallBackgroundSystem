package com.emall.service;

import com.emall.dataobject.IndexListDO;
import com.emall.error.BusinessException;

public interface IndexListService {
    void modifyIndexList(int listId,String sourceUrl,String imgUrl) throws BusinessException;
    IndexListDO getIndexList(int listId) throws BusinessException;
}
