package cn.huayq.service.impl;

import cn.huayq.config.RpcServiceConfig;
import cn.huayq.registry.RegistryService;
import cn.huayq.service.ProviderService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @Author: huangyiqiang
 * @Description:
 * @Date: Created in 13:38 2024/4/3
 */
@Component
public class ProviderServiceImpl implements ProviderService {

    @Resource
    private RegistryService registerService;

    @Override
    public void publishService(RpcServiceConfig rpcServiceConfig) {
        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            registerService.registry(rpcServiceConfig.getRpcServiceName(), new InetSocketAddress(host, 1234));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
