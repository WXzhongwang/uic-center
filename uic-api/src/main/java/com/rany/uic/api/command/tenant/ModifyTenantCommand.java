package com.rany.uic.api.command.tenant;

import com.rany.uic.api.dto.DTO;
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
public class ModifyTenantCommand extends DTO {
    /**
     * 租户Id
     */
    private Long tenantId;


    /**
     * 租户Id
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;
}
