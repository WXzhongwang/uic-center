package com.rany.uic.service.remote.isv;

import com.alibaba.dubbo.config.annotation.Service;
import com.rany.uic.api.command.isv.CreateIsvCommand;
import com.rany.uic.api.command.isv.DeleteIsvCommand;
import com.rany.uic.api.dto.Result;
import com.rany.uic.api.facade.isv.IsvFacade;
import com.rany.uic.common.enums.CommonStatusEnum;
import com.rany.uic.common.enums.DeleteStatusEnum;
import com.rany.uic.common.exception.BusinessException;
import com.rany.uic.common.exception.enums.BusinessErrorMessage;
import com.rany.uic.common.util.SnowflakeIdWorker;
import com.rany.uic.domain.aggregate.Isv;
import com.rany.uic.domain.dp.EmailAddress;
import com.rany.uic.domain.dp.IsvName;
import com.rany.uic.domain.dp.Phone;
import com.rany.uic.domain.pk.IsvId;
import com.rany.uic.domain.service.IsvDomainService;
import lombok.AllArgsConstructor;

import java.util.Objects;

import static com.rany.uic.common.Constants.DEFAULT_MAX_TENANTS;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/15 22:29
 * @email 18668485565163.com
 */
@Service
@AllArgsConstructor
public class IsvRemoteServiceProvider implements IsvFacade {

    private final IsvDomainService isvDomainService;
    private final SnowflakeIdWorker snowflakeIdWorker;

    @Override

    public Result<Boolean> createIsv(CreateIsvCommand createIsvCommand) {
        Isv isv = new Isv(new IsvId(snowflakeIdWorker.nextId()),
                new IsvName(createIsvCommand.getName(), createIsvCommand.getShortName()),
                new EmailAddress(createIsvCommand.getEmail()),
                new Phone(createIsvCommand.getPhone())
        );
        isv.setCountry(createIsvCommand.getCountry());
        isv.setUrl(createIsvCommand.getUrl());
        isv.setRegisterIp(createIsvCommand.getRegisterIp());
        isv.setDeleted(DeleteStatusEnum.NO.getValue());
        isv.setStatus(CommonStatusEnum.ENABLE.getValue());
        isv.setMaxTenants(DEFAULT_MAX_TENANTS);
        isvDomainService.save(isv);
        return Result.succeed();
    }

    @Override
    public Result<Boolean> deleteIsv(DeleteIsvCommand deleteIsvCommand) {
        Isv isv = isvDomainService.find(new IsvId(deleteIsvCommand.getId()));
        if (Objects.isNull(isv)) {
            throw new BusinessException(BusinessErrorMessage.ISV_NOT_FOUND);
        }
        if (isv.getDeleted().equals(DeleteStatusEnum.YES.getValue())) {
            throw new BusinessException(BusinessErrorMessage.ISV_DELETED);
        }
        if (isv.getStatus().equals(CommonStatusEnum.DISABLED.getValue())) {
            throw new BusinessException(BusinessErrorMessage.ISV_DISABLED);
        }
        isvDomainService.remove(isv);
        return Result.succeed(true);
    }
}
