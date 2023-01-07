package com.rany.uic.api.command.account;

import com.rany.uic.common.base.DTO;
import lombok.Data;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/30 22:00
 * @email 18668485565163.com
 */
@Data
public class EnableAccountCommand extends DTO {
    /**
     * 账号Id
     */
    private Long accountId;

    /**
     * 租户Id
     */
    private Long tenantId;
}
