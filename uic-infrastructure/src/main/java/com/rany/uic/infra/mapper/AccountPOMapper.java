package com.rany.uic.infra.mapper;

import com.rany.uic.infra.po.AccountPO;

public interface AccountPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
     *
     * @mbggenerated Thu Nov 09 08:44:38 CST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
     *
     * @mbggenerated Thu Nov 09 08:44:38 CST 2023
     */
    int insert(AccountPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
     *
     * @mbggenerated Thu Nov 09 08:44:38 CST 2023
     */
    int insertSelective(AccountPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
     *
     * @mbggenerated Thu Nov 09 08:44:38 CST 2023
     */
    AccountPO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
     *
     * @mbggenerated Thu Nov 09 08:44:38 CST 2023
     */
    int updateByPrimaryKeySelective(AccountPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
     *
     * @mbggenerated Thu Nov 09 08:44:38 CST 2023
     */
    int updateByPrimaryKey(AccountPO record);
}