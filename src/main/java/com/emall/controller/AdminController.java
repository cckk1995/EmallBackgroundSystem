package com.emall.controller;

import com.emall.controller.viewobject.AdminVO;
import com.emall.dataobject.AdminDO;
import com.emall.error.BusinessException;
import com.emall.response.CommonReturnType;
import com.emall.service.AdminService;
import com.emall.utils.DateTimeUtil;
import com.emall.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/addAdmin",method = RequestMethod.POST)
    public CommonReturnType addAdmin(@RequestParam(value = "adminName") String adminName,
                                     @RequestParam(value = "password") String password,
                                     @RequestParam(value = "email") String email,
                                     @RequestParam(value = "phone") String phone,
                                     @RequestParam(value = "gender") String gender){
        SnowFlake snowFlake = new SnowFlake(2,2);
        String adminId = String.valueOf(snowFlake.nextId());
        boolean sex = gender.equals("男")?true:false;
        Date createdDate = new Date();
        AdminDO adminDO = createAdmin(adminId,adminName,true,password,phone,email,sex,createdDate,createdDate);
        Map<String,Object> map = new HashMap<>();
        map.put("adminId",adminId);
        map.put("createdDate",createdDate);
        map.put("updatedDate",createdDate);
        try{
            adminService.addAdmin(adminDO);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
        return CommonReturnType.create(map);
    }

    @RequestMapping(value = "/deleteAdmin",method = RequestMethod.GET)
    public CommonReturnType deleteAdmin(@RequestParam(value = "idGroup") String idGroup){
        try{
            adminService.deleteAdminByIdGroup(idGroup);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
        return CommonReturnType.create("管理员删除成功");
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public CommonReturnType getAllAdmin(){
        try{
            List<AdminDO> adminDOS = adminService.getAllAdmin();
            List<AdminVO> adminVOList = new ArrayList<>();
            for(AdminDO adminDO : adminDOS){
                adminVOList.add(new AdminVO(adminDO));
            }
            return CommonReturnType.create(adminVOList);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
    }

    @RequestMapping(value = "/modifyAdmin",method = RequestMethod.POST)
    public CommonReturnType modifyAdmin(@RequestParam(value = "adminId") String adminId,
                                        @RequestParam(value = "adminName") String adminName,
                                        @RequestParam(value = "password") String password,
                                        @RequestParam(value = "email") String email,
                                        @RequestParam(value = "phone") String phone,
                                        @RequestParam(value = "gender") String gender,
                                        @RequestParam(value = "isUsed") boolean isUsed,
                                        @RequestParam(value = "createdDate") String dateString){
        boolean sex = gender.equals("男")?true:false;
        Date createdDate = DateTimeUtil.StringTODate(dateString);
        Date updateDate = new Date();
        AdminDO adminDO = createAdmin(adminId,adminName,isUsed,password,phone,email,sex,createdDate,updateDate);
        try{
            adminService.modifyAdmin(adminDO);
        }catch (BusinessException e){
            e.printStackTrace();
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
        return CommonReturnType.create("管理员添加成功");
    }

    @RequestMapping(value = "/getPassword",method = RequestMethod.GET)
    public CommonReturnType getPassword(@RequestParam(value = "adminName") String adminName){
        try{
            return CommonReturnType.create(adminService.getPassword(adminName));
        }catch (BusinessException e){
            return CommonReturnType.create(e.getErrCode()+":"+e.getErrMsg(),"false");
        }
    }

    private AdminDO createAdmin(String adminId,String adminName,boolean isUsed,
                   String password,String phone,String email,boolean gender,Date createdDate,Date updatedDate){
        AdminDO adminDO = new AdminDO();
        adminDO.setAdminId(adminId);
        adminDO.setAdminName(adminName);
        adminDO.setIsUsed(isUsed);
        adminDO.setPassword(password);
        adminDO.setPhone(phone);
        adminDO.setEmail(email);
        adminDO.setGender(gender);
        adminDO.setCreatedDate(createdDate);
        adminDO.setUpdatedDate(updatedDate);
        return adminDO;
    }
}
