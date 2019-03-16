package com.emall.service.impl;

import com.emall.dao.BuyerCommentDOMapper;
import com.emall.dao.SellerCommentDOMapper;
import com.emall.dataobject.BuyerCommentDO;
import com.emall.dataobject.SellerCommentDO;
import com.emall.error.BusinessException;
import com.emall.error.EmBusinessError;
import com.emall.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private SellerCommentDOMapper sellerCommentDOMapper;

    @Autowired
    private BuyerCommentDOMapper buyerCommentDOMapper;

    /**
     * 获得所有的卖家评论
     * @return
     * @throws BusinessException
     */
    @Override
    public List<SellerCommentDO> getSellerComment() throws BusinessException {
        List<SellerCommentDO> list = null;
       try{
           list = sellerCommentDOMapper.getAllComment();
       }catch (Exception e){
           throw new BusinessException(EmBusinessError.DATABASE_ERROR);
       }
       return list;
    }

    /**
     * 获得所有的买家评论
     * @return
     * @throws BusinessException
     */
    @Override
    public List<BuyerCommentDO> getBuyerComment() throws BusinessException {
        try{
            return buyerCommentDOMapper.getAllComment();
        }catch (Exception e) {
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     * 增加卖家评论
     * @param sellerCommentDO
     * @throws BusinessException
     */
    @Override
    public void addSellerComment(SellerCommentDO sellerCommentDO) throws BusinessException {
        try{
            sellerCommentDOMapper.insert(sellerCommentDO);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }

    /**
     * 删除卖家评论
     * @param commentId
     * @throws BusinessException
     */
    @Override
    public void deleteSellerComment(String commentId) throws BusinessException {
        try{
            sellerCommentDOMapper.deleteByPrimaryKey(commentId);
        }catch (Exception e){
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }
}
