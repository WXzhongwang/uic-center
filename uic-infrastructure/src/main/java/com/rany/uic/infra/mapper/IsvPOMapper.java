package com.rany.uic.infra.mapper;

import com.rany.uic.infra.po.IsvPO;

public interface IsvPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Thu Aug 17 23:37:07 CST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Thu Aug 17 23:37:07 CST 2023
     */
    int insert(IsvPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Thu Aug 17 23:37:07 CST 2023
     */
    int insertSelective(IsvPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Thu Aug 17 23:37:07 CST 2023
     */
    IsvPO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Thu Aug 17 23:37:07 CST 2023
     */
    int updateByPrimaryKeySelective(IsvPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table isv
     *
     * @mbggenerated Thu Aug 17 23:37:07 CST 2023
     */
    int updateByPrimaryKey(IsvPO record);
}