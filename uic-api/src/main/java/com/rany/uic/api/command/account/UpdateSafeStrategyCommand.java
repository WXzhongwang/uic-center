package com.rany.uic.api.command.account;

import com.rany.uic.api.dto.DTO;
import lombok.Data;

import java.util.Date;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/30 22:14
 * @email 18668485565163.com
 */
@Data
public class UpdateSafeStrategyCommand extends DTO {

    /**
     * accountId
     */
    private Long accountId;

    /**
     * 登录账号名
     */
    private String authCode;

    /**
     * 新密码
     */
    private String authValue;


    /**
     * 禁用时间
     */
    private Date blockAt;

    /**
     * 过期时间
     */
    private Date expiredAt;
}
