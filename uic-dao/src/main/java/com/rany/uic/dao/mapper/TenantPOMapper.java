package com.rany.uic.dao.mapper;

import com.rany.uic.dao.po.TenantPO;

public interface TenantPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    int insert(TenantPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    int insertSelective(TenantPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    TenantPO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    int updateByPrimaryKeySelective(TenantPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tenant
     *
     * @mbggenerated Tue Dec 27 21:52:46 CST 2022
     */
    int updateByPrimaryKey(TenantPO record);
}