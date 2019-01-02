package com.a3.user.Builder;

import com.a3.common.util.ExceptionUtil;
import com.a3.user.dao.UserDao;
import com.a3.user.entity.UserEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @Author: liuyaosen
 * @Date: 2019/1/2 22:21
 */
@Component
@Scope("prototype")
public class UserBuilder {
    @Autowired
    private UserDao userDao;

    private UserEntity user;

    public UserBuilder(){}

    public UserEntity build(){
        return user;
    }

    public UserBuilder add(UserEntity user){
        this.user=user;
        return this;
    }

    public UserBuilder checkForCreateNerUser() {
        if(StringUtils.isAnyEmpty(user.getUserName(),user.getPassword())){
            ExceptionUtil.invalidParam();
        }
        if(!user.getPassword().matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$")){
            ExceptionUtil.error("password too weak!");
        }
        if(!user.getUserName().matches("^[A-Za-z\\d]{6,10}$")){
            ExceptionUtil.error("incorrect username");
        }
        return this;
    }

    public UserBuilder checkUsernameExist(){
        int i = userDao.findUsername(user.getUserName());
        if (i!=0){
            ExceptionUtil.error("username already exist");
        }
        return this;
    }

    public UserBuilder newUserInfoInitialize(){
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setCreatedTime(new Date());
        user.setLastModifiedTime(new Date());
        user.setCreatedBy("himself");
        return this;
    }
}
