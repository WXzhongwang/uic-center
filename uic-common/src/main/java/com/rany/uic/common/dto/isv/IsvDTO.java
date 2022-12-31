package com.rany.uic.common.dto.isv;

import com.rany.uic.common.base.DTO;
import lombok.Data;

import java.util.Date;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/31 17:02
 * @email 18668485565163.com
 */
@Data
public class IsvDTO extends DTO {
    private Long id;
    private String name;
    private String url;
    private String shortName;
    private String country;
    private String status;
    private String isDeleted;
    private String registerIp;
    private String phone;
    private String email;
    private Date gmtCreate;
    private Date gmtModified;
    private Integer maxTenants;
}
