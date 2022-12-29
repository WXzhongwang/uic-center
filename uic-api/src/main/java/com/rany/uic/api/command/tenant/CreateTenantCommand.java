package com.rany.uic.api.command.tenant;

import com.rany.uic.api.dto.DTO;
import lombok.Data;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/15 22:38
 * @email 18668485565163.com
 */
@Data
public class CreateTenantCommand extends DTO {
    private Long isvId;
    private String name;
    private String shortName;
    private String email;
    private String phone;
    private String source;
    private Boolean initialAccount;
}
