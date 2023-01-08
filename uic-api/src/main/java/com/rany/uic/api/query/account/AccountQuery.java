package com.rany.uic.api.query.account;

import com.rany.uic.common.base.BasePageQuery;
import com.rany.uic.common.base.BaseQuery;
import com.rany.uic.common.enums.AccountTypeEnum;
import lombok.Data;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/31 16:54
 * @email 18668485565163.com
 */
@Data
public class AccountQuery extends BaseQuery {

    private Long tenantId;

    private String accountName;

    private String email;

    private String phone;

    private AccountTypeEnum accountType;

    private Boolean containsAdmin = Boolean.TRUE;

    private Boolean excludeDeleted = true;

    private Boolean excludeDisabled = false;

}
