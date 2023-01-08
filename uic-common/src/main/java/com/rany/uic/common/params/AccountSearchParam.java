package com.rany.uic.common.params;

import com.rany.uic.common.base.BaseQuery;
import lombok.Data;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2023/1/5 20:50
 * @email 18668485565163.com
 */
@Data
public class AccountSearchParam extends BaseQuery {

    private Long tenantId;

    private String accountName;

    private String email;

    private String phone;

    private String accountType;
    
    private String isAdmin;

    private String isDeleted;

    private String status;
}
