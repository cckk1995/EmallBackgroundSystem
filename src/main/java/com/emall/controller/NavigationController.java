package com.emall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emall.dataobject.NavigationDO;
import com.emall.error.BusinessException;
import com.emall.response.CommonReturnType;
import com.emall.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/navigation")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class NavigationController {
    @Autowired
    private NavigationService navigationService;

    /**
     *添加导航栏
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/addNavigation",method = RequestMethod.POST)
    public CommonReturnType addNavigation(@RequestBody JSONObject jsonObject){
        NavigationDO navigationDO = JSON.toJavaObject(jsonObject,NavigationDO.class);
        try{
            navigationService.uploadNavigation(navigationDO);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("导航栏添加成功");
    }

    /**
     * 删除导航栏
     * @param id
     * @return
     */

    @RequestMapping(value = "/deleteNavigation",method = RequestMethod.GET)
    public CommonReturnType deleteNavigation(@RequestParam(value = "id") String id){
        try{
            navigationService.deleteNavigation(id);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("导航栏删除成功");
    }

    /**
     * 修改导航栏
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/modifyNavigation",method = RequestMethod.POST)
    public CommonReturnType modifyNavigation(@RequestBody JSONObject jsonObject){
        NavigationDO navigationDO = JSON.toJavaObject(jsonObject,NavigationDO.class);
        try {
            navigationService.modifyNavigation(navigationDO);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("修改导航栏成功");
    }
}
