package com.a3.user.entity;


import com.a3.common.consts.RegexConst;
import org.hibernate.validator.constraints.Length;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * ph_user
 * @author 
 */
public class UserEntity implements Serializable {

    @Nullable
    private String id;

    @NotBlank(message = "userName is required")
    @Length(min = 6,max = 20,message = "userName's length must be between min 6 max 20")
    @Pattern(regexp = RegexConst.USER_NAME,message = "userName regex check failed. user name only allows numeric uppercase and lowercase letters.")
    private String userName;

    @NotBlank(message = "password is required")
    @Length(min = 6,max = 30,message = "password length check failed, length of password must be between min 6 max 30 characters.")
    @Pattern(regexp = RegexConst.PASSWORD,message = "password regex check failed. password only allows numeric uppercase and lowercase letters.")
    private String password;

    private String salt;

    private String nickName;

    private Date createdTime;

    private Date lastModifiedTime;

    private String createdBy;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", nickName=").append(nickName);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", lastModifiedTime=").append(lastModifiedTime);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}