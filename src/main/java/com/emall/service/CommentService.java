package com.emall.service;


import com.emall.dataobject.BuyerCommentDO;
import com.emall.dataobject.SellerCommentDO;
import com.emall.error.BusinessException;

import java.util.List;

public interface CommentService {
    List<SellerCommentDO> getSellerComment() throws BusinessException;
    List<BuyerCommentDO> getBuyerComment() throws BusinessException;
    void addSellerComment(SellerCommentDO sellerCommentDO) throws BusinessException;
    void deleteSellerComment(String commentId) throws BusinessException;
}
