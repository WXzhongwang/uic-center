package com.rany.uic.domain.po;

import java.util.Date;

public class AccountPO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.id
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.account_name
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private String accountName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.phone
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.email
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.tenant_id
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private Long tenantId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.is_admin
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private String isAdmin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.account_type
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private String accountType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.status
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.is_deleted
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private String isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.last_login_ip
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private String lastLoginIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.last_login_time
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private Date lastLoginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.feature
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private String feature;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.gmt_create
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private Date gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.gmt_modified
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private Date gmtModified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.head_image
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private String headImage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.dingding
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private String dingding;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.qq
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private String qq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.wechat
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private String wechat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.birthday
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private Date birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.tags
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    private String tags;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.id
     *
     * @return the value of account.id
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.id
     *
     * @param id the value for account.id
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.account_name
     *
     * @return the value of account.account_name
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.account_name
     *
     * @param accountName the value for account.account_name
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.phone
     *
     * @return the value of account.phone
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.phone
     *
     * @param phone the value for account.phone
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.email
     *
     * @return the value of account.email
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.email
     *
     * @param email the value for account.email
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.tenant_id
     *
     * @return the value of account.tenant_id
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public Long getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.tenant_id
     *
     * @param tenantId the value for account.tenant_id
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.is_admin
     *
     * @return the value of account.is_admin
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public String getIsAdmin() {
        return isAdmin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.is_admin
     *
     * @param isAdmin the value for account.is_admin
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin == null ? null : isAdmin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.account_type
     *
     * @return the value of account.account_type
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.account_type
     *
     * @param accountType the value for account.account_type
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.status
     *
     * @return the value of account.status
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.status
     *
     * @param status the value for account.status
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.is_deleted
     *
     * @return the value of account.is_deleted
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.is_deleted
     *
     * @param isDeleted the value for account.is_deleted
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.last_login_ip
     *
     * @return the value of account.last_login_ip
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.last_login_ip
     *
     * @param lastLoginIp the value for account.last_login_ip
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.last_login_time
     *
     * @return the value of account.last_login_time
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.last_login_time
     *
     * @param lastLoginTime the value for account.last_login_time
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.feature
     *
     * @return the value of account.feature
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public String getFeature() {
        return feature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.feature
     *
     * @param feature the value for account.feature
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setFeature(String feature) {
        this.feature = feature == null ? null : feature.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.gmt_create
     *
     * @return the value of account.gmt_create
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.gmt_create
     *
     * @param gmtCreate the value for account.gmt_create
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.gmt_modified
     *
     * @return the value of account.gmt_modified
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.gmt_modified
     *
     * @param gmtModified the value for account.gmt_modified
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.head_image
     *
     * @return the value of account.head_image
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public String getHeadImage() {
        return headImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.head_image
     *
     * @param headImage the value for account.head_image
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setHeadImage(String headImage) {
        this.headImage = headImage == null ? null : headImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.dingding
     *
     * @return the value of account.dingding
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public String getDingding() {
        return dingding;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.dingding
     *
     * @param dingding the value for account.dingding
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setDingding(String dingding) {
        this.dingding = dingding == null ? null : dingding.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.qq
     *
     * @return the value of account.qq
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public String getQq() {
        return qq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.qq
     *
     * @param qq the value for account.qq
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.wechat
     *
     * @return the value of account.wechat
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.wechat
     *
     * @param wechat the value for account.wechat
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.birthday
     *
     * @return the value of account.birthday
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.birthday
     *
     * @param birthday the value for account.birthday
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.tags
     *
     * @return the value of account.tags
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public String getTags() {
        return tags;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.tags
     *
     * @param tags the value for account.tags
     *
     * @mbggenerated Thu Jan 05 23:59:38 CST 2023
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }
}