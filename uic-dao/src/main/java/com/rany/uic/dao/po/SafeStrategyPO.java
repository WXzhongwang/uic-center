package com.rany.uic.dao.po;

import java.util.Date;

public class SafeStrategyPO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column safe_strategy.id
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column safe_strategy.account_id
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    private Long accountId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column safe_strategy.login_strategy
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    private String loginStrategy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column safe_strategy.auth_code
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    private String authCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column safe_strategy.auth_value
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    private String authValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column safe_strategy.block_at
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    private Date blockAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column safe_strategy.expired_at
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    private Date expiredAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column safe_strategy.deleted
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    private String deleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column safe_strategy.create_by
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    private String createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column safe_strategy.update_by
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    private String updateBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column safe_strategy.gmt_create
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    private Date gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column safe_strategy.gmt_modified
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    private Date gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column safe_strategy.id
     *
     * @return the value of safe_strategy.id
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column safe_strategy.id
     *
     * @param id the value for safe_strategy.id
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column safe_strategy.account_id
     *
     * @return the value of safe_strategy.account_id
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column safe_strategy.account_id
     *
     * @param accountId the value for safe_strategy.account_id
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column safe_strategy.login_strategy
     *
     * @return the value of safe_strategy.login_strategy
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public String getLoginStrategy() {
        return loginStrategy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column safe_strategy.login_strategy
     *
     * @param loginStrategy the value for safe_strategy.login_strategy
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public void setLoginStrategy(String loginStrategy) {
        this.loginStrategy = loginStrategy == null ? null : loginStrategy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column safe_strategy.auth_code
     *
     * @return the value of safe_strategy.auth_code
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column safe_strategy.auth_code
     *
     * @param authCode the value for safe_strategy.auth_code
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode == null ? null : authCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column safe_strategy.auth_value
     *
     * @return the value of safe_strategy.auth_value
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public String getAuthValue() {
        return authValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column safe_strategy.auth_value
     *
     * @param authValue the value for safe_strategy.auth_value
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public void setAuthValue(String authValue) {
        this.authValue = authValue == null ? null : authValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column safe_strategy.block_at
     *
     * @return the value of safe_strategy.block_at
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public Date getBlockAt() {
        return blockAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column safe_strategy.block_at
     *
     * @param blockAt the value for safe_strategy.block_at
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public void setBlockAt(Date blockAt) {
        this.blockAt = blockAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column safe_strategy.expired_at
     *
     * @return the value of safe_strategy.expired_at
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public Date getExpiredAt() {
        return expiredAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column safe_strategy.expired_at
     *
     * @param expiredAt the value for safe_strategy.expired_at
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column safe_strategy.deleted
     *
     * @return the value of safe_strategy.deleted
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column safe_strategy.deleted
     *
     * @param deleted the value for safe_strategy.deleted
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public void setDeleted(String deleted) {
        this.deleted = deleted == null ? null : deleted.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column safe_strategy.create_by
     *
     * @return the value of safe_strategy.create_by
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column safe_strategy.create_by
     *
     * @param createBy the value for safe_strategy.create_by
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column safe_strategy.update_by
     *
     * @return the value of safe_strategy.update_by
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column safe_strategy.update_by
     *
     * @param updateBy the value for safe_strategy.update_by
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column safe_strategy.gmt_create
     *
     * @return the value of safe_strategy.gmt_create
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column safe_strategy.gmt_create
     *
     * @param gmtCreate the value for safe_strategy.gmt_create
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column safe_strategy.gmt_modified
     *
     * @return the value of safe_strategy.gmt_modified
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column safe_strategy.gmt_modified
     *
     * @param gmtModified the value for safe_strategy.gmt_modified
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}