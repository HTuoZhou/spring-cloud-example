package com.ywstz.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ywstz.cloud.entity.Provider;
import com.ywstz.cloud.mapper.ProviderMapper;
import com.ywstz.cloud.service.IProviderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 提供表 服务实现类
 * </p>
 *
 * @author TuoZhou
 * @since 2022-06-22
 */
@Service
public class ProviderServiceImpl extends ServiceImpl<ProviderMapper, Provider> implements IProviderService {

}
