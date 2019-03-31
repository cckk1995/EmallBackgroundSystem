package com.emall.controller;

import com.emall.dataobject.IndexListItemDO;
import com.emall.error.BusinessException;
import com.emall.response.CommonReturnType;
import com.emall.service.IndexListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/indexListItem")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class IndexListItemController {

    @Autowired
    private IndexListItemService indexListItemService;

    @RequestMapping(value = "/getAllItem",method = RequestMethod.GET)
    public CommonReturnType getAllItem(@RequestParam(value = "listId") int listId){
        try{
            return CommonReturnType.create(indexListItemService.getAllIndexListItem(listId));
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
    }

    @RequestMapping(value = "/modifyItem",method = RequestMethod.POST)
    public CommonReturnType modifyItem(@RequestParam(value = "oldItemId") String oldItemId,
                                       @RequestParam(value = "itemId") String itemId,
                                       @RequestParam(value = "listId") int listId,
                                       @RequestParam(value = "sourceUrl") String sourceUrl,
                                       @RequestParam(value = "intro") String intro,
                                       @RequestParam(value = "oldPrice")BigDecimal oldPrice,
                                       @RequestParam(value = "discountType") String discountType,
                                       @RequestParam(value = "discount") String discount,
                                       @RequestParam(value = "sorted") int sorted){
        IndexListItemDO indexListItemDO = createIndexListItemDO(itemId,listId,sourceUrl,intro,oldPrice,discountType,discount,sorted);
        try{
            indexListItemService.modifyIndexListItem(oldItemId,indexListItemDO);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
        return CommonReturnType.create("修改成功");
    }

    private IndexListItemDO createIndexListItemDO(String itemId, int listId, String sourceUrl,
                                                  String intro, BigDecimal oldPrice, String discountType,
                                                  String discount, int sorted){
        IndexListItemDO indexListItemDO = new IndexListItemDO();
        indexListItemDO.setItemId(itemId);
        indexListItemDO.setDiscountType(discountType);
        indexListItemDO.setDiscount(discount);
        indexListItemDO.setIntro(intro);
        indexListItemDO.setSourceUrl(sourceUrl);
        indexListItemDO.setListId(listId);
        indexListItemDO.setOldPrice(oldPrice);
        indexListItemDO.setSorted(sorted);
        return indexListItemDO;
    }
}
