package com.rany.uic.domain.convertor;

import com.rany.uic.domain.po.SafeStrategyPO;
import com.rany.uic.domain.value.SafeStrategy;
import org.mapstruct.Mapper;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/26 00:27
 * @email 18668485565163.com
 */
@Mapper(componentModel = "spring")
public interface SafeStrategyConvertor extends BaseConvertor<SafeStrategy, SafeStrategyPO> {

}
