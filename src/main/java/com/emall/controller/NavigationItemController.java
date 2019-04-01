package com.emall.controller;

import com.emall.dataobject.NavigationItemDO;
import com.emall.error.BusinessException;
import com.emall.response.CommonReturnType;
import com.emall.service.NavigationItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/navigationItem")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class NavigationItemController {

    @Autowired
    private NavigationItemService navigationItemService;

    @RequestMapping(value = "/addNavigationItem",method = RequestMethod.POST)
    public CommonReturnType addNavigationItem(@RequestParam(value = "itemId") String itemId,
                                              @RequestParam(value = "sourceUrl") String sourceUrl,
                                              @RequestParam(value = "buyStatus") boolean buyStatus){

        NavigationItemDO navigationItemDO = createNavigationItemDO(itemId,sourceUrl,buyStatus);
        try{
            navigationItemService.addNavigationItem(navigationItemDO);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
        return CommonReturnType.create("添加导航物品成功!");
    }

    @RequestMapping(value = "/getAllNavigationItem",method = RequestMethod.GET)
    public CommonReturnType getAllNavigationItem(){
        try{
            return CommonReturnType.create(navigationItemService.getAllNavigationItem());
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
    }

    @RequestMapping(value = "/deleteNavigationItem",method = RequestMethod.GET)
    @Transactional(rollbackFor = Exception.class)
    public CommonReturnType deleteNavigationItem (@RequestParam(value = "idGroup") String idGroup){
        String[] itemIdS = idGroup.split(",");
        try{
            for(String itemId : itemIdS) {
                navigationItemService.deleteNavigationItem(itemId);
            }
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
        return CommonReturnType.create("删除成功");
    }

    private NavigationItemDO createNavigationItemDO(String itemId,String sourceUrl,boolean buyStatus){
        NavigationItemDO navigationItemDO = new NavigationItemDO();
        navigationItemDO.setItemId(itemId);
        navigationItemDO.setSourceUrl(sourceUrl);
        navigationItemDO.setItemStatus(buyStatus);
        return navigationItemDO;
    }

}
