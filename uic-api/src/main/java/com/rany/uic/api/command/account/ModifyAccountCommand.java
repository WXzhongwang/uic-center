package com.rany.uic.api.command.account;

import com.rany.uic.common.base.DTO;
import lombok.Data;

import java.util.Date;

/**
 * 更新账号基本信息
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/30 22:02
 * @email 18668485565163.com
 */
@Data
public class ModifyAccountCommand extends DTO {
    /**
     * tenantId
     */
    private Long tenantId;

    /**
     * accountId
     */
    private Long accountId;
    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String headImage;


    /**
     * dingding
     */
    private String dingding;

    /**
     * wechat
     */
    private String wechat;

    /**
     * qq
     */
    private String qq;

    /**
     * birthday
     */
    private Date birthday;

    /**
     * tags
     */
    private String tags;

    /**
     * feature
     */
    private String feature;
}
