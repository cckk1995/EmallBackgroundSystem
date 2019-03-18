package com.emall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emall.dataobject.UserDO;
import com.emall.error.BusinessException;
import com.emall.response.CommonReturnType;
import com.emall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加一个用户
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public CommonReturnType addUser(@RequestBody JSONObject jsonObject){
        UserDO userDO = JSON.toJavaObject(jsonObject,UserDO.class);
        if(userDO==null){
            return CommonReturnType.create("用户信息不全","false");
        }
        try{
            userService.addUser(userDO);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("用户添加成功");
    }

    /**
     * 修改用户信息
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/modifyuser",method = RequestMethod.POST)
    public CommonReturnType modifyUser(@RequestBody JSONObject jsonObject){
        UserDO userDO = JSON.toJavaObject(jsonObject,UserDO.class);
        if(userDO==null){
            return CommonReturnType.create("用户信息不全","false");
        }
        try{
            userService.modifyUser(userDO);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("修改用户成功");
    }

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/deleteuser",method = RequestMethod.GET)
    public CommonReturnType deleteUser(@RequestParam(value = "userId") String userId){
        if(userId==null||userId.equals("")){
            return CommonReturnType.create("没有选中要删除的用户","false");
        }
        try{
            userService.deleteUser(userId);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("用户删除成功");
    }

    /**
     * 得到所有用户信息
     * @return
     */
    @RequestMapping(value = "/getalluser",method = RequestMethod.GET)
    public CommonReturnType getAllUser(@RequestParam(value = "status") int status){
        List<UserDO> list = null;
        try{
            list = userService.getUsers(status);
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create(list);
    }

    /**
     * 获得用户密码
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getpassword",method = RequestMethod.GET)
    public CommonReturnType getPassword(@RequestParam(value = "userId") String userId){
        if(userId==null||userId.equals("")){
            return CommonReturnType.create("没有选中要删除的用户","false");
        }
        try{
            userService.getPassword(userId);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrMsg(),"false");
        }
        return CommonReturnType.create("成功获取密码");
    }
}
