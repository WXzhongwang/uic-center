package com.rany.uic.domain.service;

import com.rany.uic.domain.aggregate.Isv;
import com.rany.uic.domain.pk.IsvId;
import com.rany.uic.domain.repository.IsvRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/1 22:36
 * @email 18668485565163.com
 */
@Slf4j
@Component
public class IsvDomainService {

    @Resource
    private IsvRepository isvRepository;


    public Boolean save(Isv isv) {
        isvRepository.save(isv);
        return Boolean.TRUE;
    }

    public Boolean remove(Isv isv) {
        isvRepository.remove(isv);
        return Boolean.TRUE;
    }

    public Boolean disableIsv(Isv isv) {
        return isvRepository.disableIsv(isv);
    }

    public Isv find(IsvId isvId) {
        return isvRepository.find(isvId);
    }
}