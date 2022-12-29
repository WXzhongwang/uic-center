package com.rany.uic.dao.po;

import java.util.Date;

public class AccountPO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.id
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.user_id
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.account_type
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    private String accountType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.account_name
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    private String accountName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.mobile
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.email
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.tenant_id
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    private Long tenantId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.is_admin
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    private String isAdmin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.status
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.is_deleted
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    private String isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.last_login_ip
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    private String lastLoginIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.last_login_time
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    private Date lastLoginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.feature
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    private String feature;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.gmt_create
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    private Date gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.gmt_modified
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    private Date gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.id
     *
     * @return the value of account.id
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.user_id
     *
     * @return the value of account.user_id
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.user_id
     *
     * @param userId the value for account.user_id
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.account_type
     *
     * @return the value of account.account_type
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.account_name
     *
     * @return the value of account.account_name
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.mobile
     *
     * @return the value of account.mobile
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.mobile
     *
     * @param mobile the value for account.mobile
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.email
     *
     * @return the value of account.email
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin == null ? null : isAdmin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.status
     *
     * @return the value of account.status
     *
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
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
     * @mbggenerated Thu Dec 29 22:33:27 CST 2022
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}