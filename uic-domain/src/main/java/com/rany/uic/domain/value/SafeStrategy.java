package com.rany.uic.domain.value;

import cn.hutool.core.date.DateUtil;
import com.cake.framework.common.base.BaseValueObject;
import lombok.Data;

import java.util.Date;

/**
 * 安全策略
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/29 22:03
 * @email 18668485565163.com
 */
@Data
public class SafeStrategy extends BaseValueObject<Long> {

    private Long accountId;
    /**
     * 登录策略
     */
    private String loginStrategy;
    /**
     * 授权码
     */
    private String authCode;
    /**
     * authValue
     */
    private String authValue;
    private Date blockAt;
    private Date expiredAt;
    
    public Boolean isBlocked() {
        return this.blockAt != null
                && DateUtil.date().before(blockAt);
    }

    public Boolean isExpired() {
        return this.expiredAt != null
                && DateUtil.date().before(expiredAt);
    }
}
