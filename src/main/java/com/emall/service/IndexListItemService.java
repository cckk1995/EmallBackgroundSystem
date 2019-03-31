package com.emall.service;

import com.emall.controller.viewobject.IndexListItemVO;
import com.emall.dataobject.IndexListItemDO;
import com.emall.error.BusinessException;

import java.util.List;

public interface IndexListItemService {
    List<IndexListItemVO> getAllIndexListItem(int listId) throws BusinessException;
    void modifyIndexListItem(String oldItemId,IndexListItemDO indexListItemDO) throws BusinessException;
}
