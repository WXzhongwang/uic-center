package com.rany.uic.dao.mapper;

import com.rany.uic.dao.po.SafeStrategyPO;

public interface SafeStrategyPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table safe_strategy
     *
     * @mbggenerated Fri Dec 30 22:53:02 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table safe_strategy
     *
     * @mbggenerated Fri Dec 30 22:53:02 CST 2022
     */
    int insert(SafeStrategyPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table safe_strategy
     *
     * @mbggenerated Fri Dec 30 22:53:02 CST 2022
     */
    int insertSelective(SafeStrategyPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table safe_strategy
     *
     * @mbggenerated Fri Dec 30 22:53:02 CST 2022
     */
    SafeStrategyPO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table safe_strategy
     *
     * @mbggenerated Fri Dec 30 22:53:02 CST 2022
     */
    int updateByPrimaryKeySelective(SafeStrategyPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table safe_strategy
     *
     * @mbggenerated Fri Dec 30 22:53:02 CST 2022
     */
    int updateByPrimaryKey(SafeStrategyPO record);
}