package com.rany.uic.api.query.account;

import com.rany.uic.common.base.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/31 16:57
 * @email 18668485565163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AccountDingIdQuery extends BaseQuery {

    private String dingUnionId;
    private String dingUserId;
    private Long tenantId;
}
