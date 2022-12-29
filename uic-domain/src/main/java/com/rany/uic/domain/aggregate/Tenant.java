package com.rany.uic.domain.aggregate;

import com.cake.framework.common.base.BaseAggregateRoot;
import com.cake.framework.common.base.IAggregate;
import com.rany.uic.domain.dp.EmailAddress;
import com.rany.uic.domain.dp.Phone;
import com.rany.uic.domain.dp.TenantName;
import com.rany.uic.domain.dp.TenantSource;
import com.rany.uic.domain.pk.IsvId;
import com.rany.uic.domain.pk.TenantId;
import lombok.*;

/**
 * Account 聚合根
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/26 00:11
 * @email 18668485565163.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Tenant extends BaseAggregateRoot implements IAggregate<TenantId> {
    /**
     * PK
     */
    private TenantId id;

    /**
     * isv
     */
    private IsvId isvId;
    /**
     * 租户名称名称
     */
    private TenantName tenantName;

    /**
     * 邮件地址
     */
    private EmailAddress emailAddress;

    /**
     * 邮件地址
     */
    private TenantSource source;

    /**
     * 联系电话
     */
    private Phone phone;

    private String deleted;

    public Boolean save() {
        return Boolean.TRUE;
    }

    public Boolean freeze() {
        return true;
    }

    public Boolean delete() {
        return true;
    }
}
