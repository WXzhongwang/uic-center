package com.rany.uic.api.query.tenant;

import com.rany.uic.common.base.BasePageQuery;
import lombok.Data;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/31 16:47
 * @email 18668485565163.com
 */
@Data
public class TenantPageQuery extends BasePageQuery {

    private Long isvId;

    private String name;

    private Boolean excludeDeleted = true;

    private Boolean excludeDisabled = false;
}
