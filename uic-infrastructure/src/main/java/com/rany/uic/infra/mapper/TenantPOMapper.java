package com.rany.uic.infra.mapper;

import com.rany.uic.infra.po.TenantPO;

public interface TenantPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant
     *
     * @mbggenerated Sun Nov 12 14:20:44 CST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant
     *
     * @mbggenerated Sun Nov 12 14:20:44 CST 2023
     */
    int insert(TenantPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant
     *
     * @mbggenerated Sun Nov 12 14:20:44 CST 2023
     */
    int insertSelective(TenantPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant
     *
     * @mbggenerated Sun Nov 12 14:20:44 CST 2023
     */
    TenantPO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant
     *
     * @mbggenerated Sun Nov 12 14:20:44 CST 2023
     */
    int updateByPrimaryKeySelective(TenantPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant
     *
     * @mbggenerated Sun Nov 12 14:20:44 CST 2023
     */
    int updateByPrimaryKey(TenantPO record);
}