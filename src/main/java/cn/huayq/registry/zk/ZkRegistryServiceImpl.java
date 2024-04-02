package cn.huayq.registry.zk;

import cn.huayq.registry.RegistryService;

import java.net.InetSocketAddress;

/**
 * @Author: huangyiqiang
 * @Description: zk服务注册与发现
 * @Date: Created in 13:45 2024/4/2
 */
public class ZkRegistryServiceImpl implements RegistryService {

    @Override
    public void registry(String serviceName, InetSocketAddress inetSocketAddress) {

    }

    @Override
    public InetSocketAddress discovery() {
        return null;
    }
}
