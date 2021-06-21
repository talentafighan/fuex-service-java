package com.service.fuex.web.dto;

import com.service.fuex.web.model.UserStatus;
import com.service.fuex.web.model.UserType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class UserDTO {

    private Long userId;

    @NotBlank(message = "CAN NOT BE EMPTY")
    @Size(max = 255, message = "MAXIMUM 255 CHARACTERS")
    private String username;

    private Date createDate;

    @NotBlank(message = "CAN NOT BE EMPTY")
    @Size(max = 255, message = "MAXIMUM 255 CHARACTERS")
    private String fullName;

    @Email(message = "MUST CONTAIN EMAIL")
    @Size(max = 255, message = "MAXIMUM 255 CHARACTERS")
    private String email;

    @NotNull(message = "CAN NOT BE EMPTY")
    @Size(max = 255, message = "MAXIMUM 255 CHARACTERS")
    private int mobilePhoneNumber;

    @NotBlank(message = "CAN NOT BE EMPTY")
    @Size(max = 255, message = "MAXIMUM 255 CHARACTERS")
    private String userStatus;

    private UserStatus userStatusId;

    @NotBlank(message = "CAN NOT BE EMPTY")
    @Size(max = 255, message = "MAXIMUM 255 CHARACTERS")
    private String userType;

    private UserType userTypeId;

    // SETTER 7 GETTER
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(int mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public UserStatus getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(UserStatus userStatusId) {
        this.userStatusId = userStatusId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public UserType getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(UserType userTypeId) {
        this.userTypeId = userTypeId;
    }
}
