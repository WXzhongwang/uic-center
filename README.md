# CAKE UIC
介绍
cake-acl 是一个基于 SpringBoot + UIC 的服务端应用, 统一用户中心。

springboot 2.2.6.RELEASE

特性:

- [x] **Java**  : 支持二开，设计简单，支持快速集成
- [x] **SpringBoot**: 接入快速，支持mvc+webflux快速接入
- [x] **多应用多租户**: 支持多应用多租户模式
- [x] **服务化**: zookeeper+dubbo
- [x] **shenyu**: 接入apache shenyu



参考：
![RBAC模型](https://github.com/WXzhongwang/uic-center/blob/main/WX20231015-225622@2x.png)

## shenyu接入
![shenyu](https://github.com/WXzhongwang/uic-center/blob/main/images/shenyu.png)

![接口](https://github.com/WXzhongwang/uic-center/blob/main/images/shenyu-uic.png)

## GAV
```xml
 <dependency>
    <groupId>com.rany.uic</groupId>
    <artifactId>uic-api</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```



## 接口
### 账号管理
```java
package com.rany.uic.api.facade.account;

import com.cake.framework.common.response.ListResult;
import com.cake.framework.common.response.PageResult;
import com.cake.framework.common.response.PojoResult;
import com.rany.uic.api.command.account.*;
import com.rany.uic.api.query.account.AccountBasicQuery;
import com.rany.uic.api.query.account.AccountDingIdQuery;
import com.rany.uic.api.query.account.AccountPageQuery;
import com.rany.uic.api.query.account.AccountQuery;
import com.rany.uic.common.dto.account.AccountDTO;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/27 20:39
 * @email 18668485565163.com
 */
public interface AccountFacade {


    /**
     * 创建租户账号
     *
     * @param createAccountCommand
     * @return
     */
    PojoResult<Long> createAccount(CreateAccountCommand createAccountCommand);

    /**
     * 获取账号信息
     *
     * @param accountBasicQuery
     * @return
     */
    PojoResult<AccountDTO> getAccount(AccountBasicQuery accountBasicQuery);


    /**
     * 获取账号信息
     *
     * @param accountBasicQuery
     * @return
     */
    PojoResult<AccountDTO> getAccountByDingId(AccountDingIdQuery accountBasicQuery);

    /**
     * 账号禁用
     *
     * @param disableAccountCommand
     * @return
     */
    PojoResult<Boolean> disableAccount(DisableAccountCommand disableAccountCommand);

    /**
     * 启用账号
     *
     * @param enableAccountCommand
     * @return
     */
    PojoResult<Boolean> enableAccount(EnableAccountCommand enableAccountCommand);

    /**
     * 删除账户
     *
     * @param deleteAccountCommand
     * @return
     */
    PojoResult<Boolean> deleteAccount(DeleteAccountCommand deleteAccountCommand);

    /**
     * 更新账号基本信息
     *
     * @param modifyAccountCommand
     * @return
     */
    PojoResult<Boolean> modifyAccount(ModifyAccountCommand modifyAccountCommand);

    /**
     * 创建登录策略
     *
     * @param createSafeStrategyCommand
     * @return
     */
    PojoResult<Boolean> createSafeStrategy(CreateSafeStrategyCommand createSafeStrategyCommand);

    /**
     * 更新登录策略
     *
     * @param updateSafeStrategyCommand
     * @return
     */
    PojoResult<Boolean> updateSafeStrategy(UpdateSafeStrategyCommand updateSafeStrategyCommand);


    /**
     * 分页查询账号
     *
     * @param accountQuery
     * @return
     */
    ListResult<AccountDTO> findAccounts(AccountQuery accountQuery);

    /**
     * 查询账号
     *
     * @param accountPageQuery
     * @return
     */
    PageResult<AccountDTO> pageAccounts(AccountPageQuery accountPageQuery);

}

```
### ISV管理
```java
package com.rany.uic.api.facade.isv;

import com.cake.framework.common.response.PojoResult;
import com.rany.uic.api.command.isv.CreateIsvCommand;
import com.rany.uic.api.command.isv.DeleteIsvCommand;
import com.rany.uic.api.command.isv.DisableIsvCommand;
import com.rany.uic.api.command.isv.EnableIsvCommand;
import com.rany.uic.api.query.isv.IsvBasicQuery;
import com.rany.uic.common.dto.isv.IsvDTO;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/15 22:21
 * @email 18668485565163.com
 */
public interface IsvFacade {


    /**
     * 创建ISV
     *
     * @param createIsvCommand
     * @return
     */
    PojoResult<Boolean> createIsv(CreateIsvCommand createIsvCommand);

    /**
     * ISV 删除
     *
     * @param deleteIsvCommand
     * @return
     */
    PojoResult<Boolean> deleteIsv(DeleteIsvCommand deleteIsvCommand);


    /**
     * 禁用ISV
     *
     * @param disableIsvCommand
     * @return
     */
    PojoResult<Boolean> disableIsv(DisableIsvCommand disableIsvCommand);


    /**
     * 启用ISV
     *
     * @param enableIsvCommand
     * @return
     */
    PojoResult<Boolean> enableIsv(EnableIsvCommand enableIsvCommand);


    /**
     * 查询ISV基本信息
     *
     * @param isvBaseQuery
     * @return
     */
    PojoResult<IsvDTO> findIsv(IsvBasicQuery isvBaseQuery);
}

```

### 租户管理
```java
package com.rany.uic.api.facade.tenant;

import com.cake.framework.common.response.ListResult;
import com.cake.framework.common.response.PageResult;
import com.cake.framework.common.response.PojoResult;
import com.rany.uic.api.command.tenant.*;
import com.rany.uic.api.query.tenant.TenantBasicQuery;
import com.rany.uic.api.query.tenant.TenantPageQuery;
import com.rany.uic.api.query.tenant.TenantQuery;
import com.rany.uic.common.dto.tenant.TenantDTO;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/15 22:21
 * @email 18668485565163.com
 */
public interface TenantFacade {


    /**
     * 创建租户
     *
     * @param createTenantCommand
     * @return
     */
    PojoResult<Boolean> createTenant(CreateTenantCommand createTenantCommand);

    /**
     * 更新租户
     *
     * @param modifyTenantCommand
     * @return
     */
    PojoResult<Boolean> modifyTenant(ModifyTenantCommand modifyTenantCommand);

    /**
     * 租户禁用
     *
     * @param disableTenantCommand
     * @return
     */
    PojoResult<Boolean> disableTenant(DisableTenantCommand disableTenantCommand);

    /**
     * 启用租户
     *
     * @param enableTenantCommand
     * @return
     */
    PojoResult<Boolean> enableTenant(EnableTenantCommand enableTenantCommand);

    /**
     * 启用租户
     *
     * @param deleteTenantCommand
     * @return
     */
    PojoResult<Boolean> deleteTenant(DeleteTenantCommand deleteTenantCommand);


    /**
     * 查询单个租户信息
     *
     * @param tenantBasicQuery
     * @return
     */
    PojoResult<TenantDTO> getTenant(TenantBasicQuery tenantBasicQuery);


    /**
     * 查询指定isv全部租户信息
     *
     * @param tenantQuery
     * @return
     */
    ListResult<TenantDTO> findTenants(TenantQuery tenantQuery);

    /**
     * 分页查询租户信息
     *
     * @param tenantPageQuery
     * @return
     */
    PageResult<TenantDTO> pageTenants(TenantPageQuery tenantPageQuery);
}

```