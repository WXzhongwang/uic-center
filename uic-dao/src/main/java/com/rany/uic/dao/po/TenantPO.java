package com.rany.uic.dao.po;

import java.util.Date;

public class TenantPO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tenant.id
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tenant.isv_id
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    private Long isvId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tenant.name
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tenant.short_name
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    private String shortName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tenant.email
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tenant.source
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    private String source;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tenant.phone
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tenant.is_deleted
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    private String isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tenant.create_by
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    private String createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tenant.update_by
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    private String updateBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tenant.gmt_create
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    private Date gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tenant.gmt_modified
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    private Date gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tenant.id
     *
     * @return the value of tenant.id
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tenant.id
     *
     * @param id the value for tenant.id
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tenant.isv_id
     *
     * @return the value of tenant.isv_id
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public Long getIsvId() {
        return isvId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tenant.isv_id
     *
     * @param isvId the value for tenant.isv_id
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public void setIsvId(Long isvId) {
        this.isvId = isvId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tenant.name
     *
     * @return the value of tenant.name
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tenant.name
     *
     * @param name the value for tenant.name
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tenant.short_name
     *
     * @return the value of tenant.short_name
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tenant.short_name
     *
     * @param shortName the value for tenant.short_name
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tenant.email
     *
     * @return the value of tenant.email
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tenant.email
     *
     * @param email the value for tenant.email
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tenant.source
     *
     * @return the value of tenant.source
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public String getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tenant.source
     *
     * @param source the value for tenant.source
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tenant.phone
     *
     * @return the value of tenant.phone
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tenant.phone
     *
     * @param phone the value for tenant.phone
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tenant.is_deleted
     *
     * @return the value of tenant.is_deleted
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tenant.is_deleted
     *
     * @param isDeleted the value for tenant.is_deleted
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tenant.create_by
     *
     * @return the value of tenant.create_by
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tenant.create_by
     *
     * @param createBy the value for tenant.create_by
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tenant.update_by
     *
     * @return the value of tenant.update_by
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tenant.update_by
     *
     * @param updateBy the value for tenant.update_by
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tenant.gmt_create
     *
     * @return the value of tenant.gmt_create
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tenant.gmt_create
     *
     * @param gmtCreate the value for tenant.gmt_create
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tenant.gmt_modified
     *
     * @return the value of tenant.gmt_modified
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tenant.gmt_modified
     *
     * @param gmtModified the value for tenant.gmt_modified
     *
     * @mbggenerated Thu Dec 29 23:09:58 CST 2022
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}