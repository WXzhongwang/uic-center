package com.rany.uic.domain.aggregate;

import com.cake.framework.common.base.BaseAggregateRoot;
import com.cake.framework.common.base.IAggregate;
import com.rany.uic.common.enums.CommonStatusEnum;
import com.rany.uic.common.enums.DeleteStatusEnum;
import com.rany.uic.domain.dp.EmailAddress;
import com.rany.uic.domain.dp.IsvName;
import com.rany.uic.domain.dp.Phone;
import com.rany.uic.domain.pk.IsvId;
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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Isv extends BaseAggregateRoot implements IAggregate<IsvId> {
    private IsvId id;
    /**
     * isv名称
     */
    private IsvName name;

    /**
     * 地址
     */
    private EmailAddress emailAddress;

    /**
     * 手机号
     */
    private Phone phone;

    /**
     * 租户个数
     */
    private Integer maxTenants;

    /**
     * url
     */
    private String url;

    /**
     * 国家
     */
    private String country;


    /**
     * 状态
     */
    private String status;

    /**
     * ip地址
     */
    private String registerIp;


    @Builder
    public Isv(IsvId isvId, IsvName isvName, EmailAddress emailAddress, Phone phone) {
        this.id = isvId;
        this.name = isvName;
        this.emailAddress = emailAddress;
        this.phone = phone;
    }

    /**
     * 启用
     * TODO 后续这些行为上可以补充事件的领域处理的注册
     */
    public void enable() {
        this.status = CommonStatusEnum.DISABLED.getValue();
    }

    /**
     * 禁用
     */
    public void disable() {
        this.status = CommonStatusEnum.DISABLED.getValue();
    }

    /**
     * 删除
     */
    public void delete() {
        this.isDeleted = DeleteStatusEnum.YES.getValue();
    }
}
