package cn.huayq.registry;

import java.net.InetSocketAddress;

/**
 * @Author: huangyiqiang
 * @Description: 注册中心服务
 * @Date: Created in 11:04 2024/4/2
 */
public interface RegistryService {

    void registry(String serviceName, InetSocketAddress inetSocketAddress);

    InetSocketAddress discovery();
}
