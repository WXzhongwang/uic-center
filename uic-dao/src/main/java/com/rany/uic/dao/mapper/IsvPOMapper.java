package com.rany.uic.dao.mapper;

import com.rany.uic.dao.po.IsvPO;

public interface IsvPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Fri Dec 30 22:13:05 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Fri Dec 30 22:13:05 CST 2022
     */
    int insert(IsvPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Fri Dec 30 22:13:05 CST 2022
     */
    int insertSelective(IsvPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Fri Dec 30 22:13:05 CST 2022
     */
    IsvPO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Fri Dec 30 22:13:05 CST 2022
     */
    int updateByPrimaryKeySelective(IsvPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Fri Dec 30 22:13:05 CST 2022
     */
    int updateByPrimaryKey(IsvPO record);
}