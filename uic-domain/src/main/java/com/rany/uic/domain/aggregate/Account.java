package com.rany.uic.domain.aggregate;

import cn.hutool.core.date.DateUtil;
import com.cake.framework.common.base.BaseAggregateRoot;
import com.cake.framework.common.base.IAggregate;
import com.rany.uic.common.enums.CommonStatusEnum;
import com.rany.uic.common.enums.DeleteStatusEnum;
import com.rany.uic.domain.dp.AccountName;
import com.rany.uic.domain.dp.EmailAddress;
import com.rany.uic.domain.dp.HeadImage;
import com.rany.uic.domain.dp.Phone;
import com.rany.uic.domain.event.AccountCreatedEvent;
import com.rany.uic.domain.pk.AccountId;
import com.rany.uic.domain.pk.TenantId;
import com.rany.uic.domain.value.SafeStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.List;

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
public class Account extends BaseAggregateRoot implements IAggregate<AccountId> {

    /**
     * 主键
     */
    private AccountId id;

    /**
     * 租户Id
     */
    private TenantId tenantId;
    /**
     * 用户名称
     */
    private AccountName accountName;


    /**
     * 安全策略
     */
    private List<SafeStrategy> safeStrategies;


    /**
     * 邮箱
     */
    private EmailAddress emailAddress;


    /**
     * 电话
     */
    private Phone phone;

    /**
     * 账号类型
     */
    private String accountType;


    /**
     * 是否是租户管理员
     */
    private Boolean isAdmin;

    /**
     * 状态
     */
    private String status;


    private String lastLoginIp;
    private Date lastLoginTime;
    private String feature;

    /**
     * 头像
     */
    private HeadImage headImage;


    public Account(AccountId id, TenantId tenantId, AccountName accountName, List<SafeStrategy> safeStrategies) {
        this.id = id;
        this.tenantId = tenantId;
        this.accountName = accountName;
        this.safeStrategies = safeStrategies;
    }

    /**
     * 账号信息保存
     *
     * @return
     */
    public Boolean save() {
        this.gmtCreate = DateUtil.date();
        this.gmtModified = DateUtil.date();
        this.isDeleted = DeleteStatusEnum.NO.getValue();
        this.status = CommonStatusEnum.ENABLE.getValue();
        this.registerEvent(new AccountCreatedEvent(this, DateUtil.date()));
        return Boolean.TRUE;
    }
}
