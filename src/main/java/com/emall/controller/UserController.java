package com.emall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.emall.controller.viewobject.UserVO;
import com.emall.dataobject.UserDO;
import com.emall.dataobject.UserPasswordDO;
import com.emall.error.BusinessException;
import com.emall.response.CommonReturnType;
import com.emall.service.UserService;
import com.emall.utils.DateTimeUtil;
import com.emall.utils.SnowFlake;
import com.emall.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 添加一个用户
     * @param userName
     * @param password
     * @param email
     * @param phone
     * @param gender
     * @param avatarUrl
     * @param hometown
     * @param birthday
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public CommonReturnType addUser(@RequestParam(value = "userName") String userName,
                                    @RequestParam(value = "password") String password,
                                    @RequestParam(value = "address") String[] address,
                                    @RequestParam(value = "email") String email,
                                    @RequestParam(value = "phone") String phone,
                                    @RequestParam(value = "gender") String gender,
                                    @RequestParam(value = "avatarUrl") String avatarUrl,
                                    @RequestParam(value = "hometown") String[] hometown,
                                    @RequestParam(value = "birthday") Date birthday){
        SnowFlake snowFlake = new SnowFlake(1,1);
        boolean sex = gender.equals("男")?true:false;
        String userId = String.valueOf(snowFlake.nextId());
        UserDO userDO = new UserDO(userId,userName,true,"无",phone,StringUtil.stringArrayToString(address),email,sex,avatarUrl,birthday, StringUtil.stringArrayToString(hometown));
        UserPasswordDO userPasswordDO = new UserPasswordDO(userId,password);
        try{
            userService.addUser(userDO,userPasswordDO);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
        return CommonReturnType.create(userId);
    }

    /**
     * 修改用户信息
     * @param userName
     * @param password
     * @param address
     * @param email
     * @param phone
     * @param gender
     * @param avatarUrl
     * @param hometown
     * @param birthdayString
     * @return
     */
    @RequestMapping(value = "/modifyUser",method = RequestMethod.POST)
    public CommonReturnType modifyUser(@RequestParam(value = "userId") String userId,
                                       @RequestParam(value = "userName") String userName,
                                       @RequestParam(value = "password") String password,
                                       @RequestParam(value = "address") String[] address,
                                       @RequestParam(value = "email") String email,
                                       @RequestParam(value = "phone") String phone,
                                       @RequestParam(value = "gender") String gender,
                                       @RequestParam(value = "avatarUrl") String avatarUrl,
                                       @RequestParam(value = "hometown") String[] hometown,
                                       @RequestParam(value = "birthday") String birthdayString){

        boolean sex = gender.equals("男")?true:false;
        Date birthday = DateTimeUtil.StringTODate(birthdayString);
        UserDO userDO = new UserDO(userId,userName,true,"张三",phone,StringUtil.stringArrayToString(address),email,sex,avatarUrl,
               birthday,StringUtil.stringArrayToString(hometown));
       UserPasswordDO userPasswordDO = new UserPasswordDO(userId,password);
       try{
           userService.modifyUser(userDO,userPasswordDO);
       }catch (BusinessException e){
           return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
       }
       return CommonReturnType.create("修改用户成功！");
    }

    /**
     * 删除用户信息
     * @param idGroup
     * @return
     */
    @RequestMapping(value = "/deleteUsers",method = RequestMethod.GET)
    public CommonReturnType deleteUser(@RequestParam(value = "idGroup") String idGroup){
        try{
            userService.deleteUsers(idGroup);
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
        return CommonReturnType.create("删除用户成功");
    }

    /**
     * 得到所有用户信息
     * @return
     */
    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public CommonReturnType getAllUser(){
        List<UserVO> list = null;
        try{
            list = userService.getUsers();
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
        return CommonReturnType.create(list);
    }

    /**
     * 获得用户密码
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getPassword",method = RequestMethod.GET)
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
