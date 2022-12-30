package com.rany.uic.api.command.account;

import com.rany.uic.api.dto.DTO;
import lombok.Data;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/27 20:40
 * @email 18668485565163.com
 */
@Data
public class CreateAccountCommand extends DTO {

    /**
     * 租户Id
     */
    private Long tenantId;

    /**
     * 账号名
     */
    private String accountName;

    /**
     * 账号类型
     */
    private String accountType;

    /**
     * 来源
     */
    private String source;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String headImage;

    /**
     * 是否是租户管理员
     */
    private Boolean isAdmin;

    /**
     * 初始账号
     */
    private String loginName;

    /**
     * 初始密码
     */
    private String loginPwd;
}
