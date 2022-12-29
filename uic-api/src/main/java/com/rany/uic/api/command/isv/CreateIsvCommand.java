package com.rany.uic.api.command.isv;

import com.rany.uic.api.dto.DTO;
import lombok.Data;

/**
 * CreateIsvCommand
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/15 22:27
 * @email 18668485565163.com
 */
@Data
public class CreateIsvCommand extends DTO {

    private String name;
    private String shortName;
    private String email;
    private String url;
    private String phone;
    private String country;
    private String registerIp;
}
