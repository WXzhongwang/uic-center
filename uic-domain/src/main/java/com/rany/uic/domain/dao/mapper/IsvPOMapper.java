package com.rany.uic.dao.mapper;

import com.rany.uic.dao.po.IsvPO;

public interface IsvPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Thu Jan 05 23:37:49 CST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Thu Jan 05 23:37:49 CST 2023
     */
    int insert(IsvPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Thu Jan 05 23:37:49 CST 2023
     */
    int insertSelective(IsvPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Thu Jan 05 23:37:49 CST 2023
     */
    IsvPO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Thu Jan 05 23:37:49 CST 2023
     */
    int updateByPrimaryKeySelective(IsvPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Thu Jan 05 23:37:49 CST 2023
     */
    int updateByPrimaryKey(IsvPO record);
}