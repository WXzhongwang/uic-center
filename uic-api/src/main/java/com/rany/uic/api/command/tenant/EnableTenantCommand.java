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
public class EnableTenantCommand extends DTO {
    /**
     * 租户Id
     */
    private Long tenantId;
}
