package com.emall.controller.viewobject;

import com.emall.dataobject.AdminDO;

import java.util.Date;

public class AdminVO {
    private String adminId;
    private String adminName;
    private Boolean isUsed;
    private String password;
    private String phone;
    private String email;
    private String gender;
    private Date createdDate;
    private Date updatedDate;
    public AdminVO(AdminDO adminDO){
        this.adminId = adminDO.getAdminId();
        this.adminName = adminDO.getAdminName();
        this.isUsed = adminDO.getIsUsed();
        this.password = adminDO.getPassword();
        this.phone = adminDO.getPhone();
        this.email = adminDO.getEmail();
        this.gender = adminDO.getGender()?"男":"女";
        this.createdDate = adminDO.getCreatedDate();
        this.updatedDate = adminDO.getUpdatedDate();
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
