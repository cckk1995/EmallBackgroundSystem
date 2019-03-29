package com.emall.controller;

import com.emall.dataobject.AdminDO;
import com.emall.error.BusinessException;
import com.emall.response.CommonReturnType;
import com.emall.service.AdminService;
import com.emall.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/admin")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public CommonReturnType addAdmin(@RequestParam(value = "adminName") String adminName,
                                     @RequestParam(value = "password") String password,
                                     @RequestParam(value = "email") String email,
                                     @RequestParam(value = "phone") String phone,
                                     @RequestParam(value = "gender") String gender){
        SnowFlake snowFlake = new SnowFlake(2,2);
        String adminId = String.valueOf(snowFlake.nextId());
        boolean sex = gender.equals("男")?true:false;
        Date createdDate = new Date();
        AdminDO adminDO = new AdminDO(adminId,adminName,true,password,phone,email,sex,createdDate,createdDate);
        try{
            adminService.addAdmin(adminDO);
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
        return CommonReturnType.create("管理员添加成功");
    }

    @RequestMapping(value = "/deleteAdmin",method = RequestMethod.GET)
    public CommonReturnType deleteAdmin(@RequestParam(value = "idGroup") String idGroup){
        try{
            adminService.deleteAdminByIdGroup(idGroup);
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
        return CommonReturnType.create("管理员删除成功");
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public CommonReturnType getAllAdmin(){
        try{
            return CommonReturnType.create(adminService.getAllAdmin());
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public CommonReturnType modifyAdmin(@RequestParam(value = "adminId") String adminId,
                                        @RequestParam(value = "adminName") String adminName,
                                        @RequestParam(value = "password") String password,
                                        @RequestParam(value = "email") String email,
                                        @RequestParam(value = "phone") String phone,
                                        @RequestParam(value = "gender") String gender,
                                        @RequestParam(value = "isUsed") boolean isUsed,
                                        @RequestParam(value = "createdDate") Date createdDate){
        boolean sex = gender.equals("男")?true:false;
        Date updateDate = new Date();
        AdminDO adminDO = new AdminDO(adminId,adminName,isUsed,password,phone,email,sex,createdDate,updateDate);
        try{
            adminService.modifyAdmin(adminDO);
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
        return CommonReturnType.create("管理员添加成功");
    }
}
