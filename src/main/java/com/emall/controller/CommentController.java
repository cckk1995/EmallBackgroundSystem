package com.emall.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emall.dataobject.SellerCommentDO;
import com.emall.error.BusinessException;
import com.emall.response.CommonReturnType;
import com.emall.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 获得所有买家评论
     * @return
     */
    @RequestMapping(value = "/getsellercomment",method = RequestMethod.GET)
    public CommonReturnType getSellerComment(){
        try{
            return CommonReturnType.create(commentService.getSellerComment());
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
    }

    /**
     * 获得所有卖家评论
     * @return
     */
    @RequestMapping(value = "/getbuyercomment",method = RequestMethod.GET)
    public CommonReturnType getBuyerComment(){
        try{
            return CommonReturnType.create(commentService.getBuyerComment());
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
    }

    /**
     * 添加卖家评论
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/addsellercomment",method = RequestMethod.POST)
    public CommonReturnType addBuyerComment(@RequestBody JSONObject jsonObject){
        SellerCommentDO sellerCommentDO = JSON.toJavaObject(jsonObject,SellerCommentDO.class);
        try{
            commentService.addSellerComment(sellerCommentDO);
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("添加评论成功");
    }

    @RequestMapping(value = "/deletesellercomment",method = RequestMethod.GET)
    public CommonReturnType deleteSellerComment(@RequestParam(value = "commentId") String commentId){
        try{
            commentService.deleteSellerComment(commentId);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("评论删除成功");
    }
}
