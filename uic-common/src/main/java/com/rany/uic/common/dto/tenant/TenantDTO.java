package com.rany.uic.common.dto.tenant;

import com.rany.uic.common.base.DTO;
import lombok.Data;

import java.util.Date;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/31 18:29
 * @email 18668485565163.com
 */
@Data
public class TenantDTO extends DTO {
    private Long id;
    private Long isvId;
    private String name;
    private String shortName;
    private String email;
    private String source;
    private String phone;
    private String isDeleted;
    private Date gmtCreate;
    private Date gmtModified;
    private String address;
    private String status;
}
