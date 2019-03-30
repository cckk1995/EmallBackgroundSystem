package com.emall.controller;

import com.emall.error.BusinessException;
import com.emall.response.CommonReturnType;
import com.emall.service.IndexListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/indexList")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class IndexListController {

    @Autowired
    private IndexListService indexListService;

    @RequestMapping(value = "/getIndexList",method = RequestMethod.GET)
    public CommonReturnType getIndexList(@RequestParam(value = "listId") int listId){
        try{
            return CommonReturnType.create(indexListService.getIndexList(listId));
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg()+":"+e.getErrMsg(),"false");
        }
    }

    @RequestMapping(value = "/modifyIndexList",method = RequestMethod.GET)
    public CommonReturnType modifyIndexList(@RequestParam(value = "listId") int listId,
                                            @RequestParam(value = "sourceUrl") String sourceUrl,
                                            @RequestParam(value = "imgUrl") String imgUrl){
        try{
            indexListService.modifyIndexList(listId,sourceUrl,imgUrl);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg()+":"+e.getErrMsg(),"false");
        }
        return CommonReturnType.create("修改成功！");
    }
}
