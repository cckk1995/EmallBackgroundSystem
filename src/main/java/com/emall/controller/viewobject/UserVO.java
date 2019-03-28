package com.emall.controller.viewobject;

import com.emall.dataobject.UserDO;
import com.emall.dataobject.UserPasswordDO;
import com.emall.utils.StringUtil;

import java.util.Date;

public class UserVO {
    private String userId;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String gender;
    private String[] address;
    private String avatarUrl;
    private Date birthday;
    private String[] hometown;

    public UserVO(UserDO userDO, UserPasswordDO userPasswordDO){
        this.userId = userDO.getUserId();
        this.userName = userDO.getUserName();
        this.password = userPasswordDO.getEncrptPassword();
        this.email = userDO.getEmail();
        this.phone = userDO.getTelephone();
        this.gender = (userDO.getGender()==true)?"男":"女";
        this.address = StringUtil.stringToStringArray(userDO.getAddress());
        this.avatarUrl = userDO.getAvatarUrl();
        this.birthday = userDO.getBirthday();
        this.hometown = StringUtil.stringToStringArray(userDO.getHometown());
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String[] getHometown() {
        return hometown;
    }

    public void setHometown(String[] hometown) {
        this.hometown = hometown;
    }
}
