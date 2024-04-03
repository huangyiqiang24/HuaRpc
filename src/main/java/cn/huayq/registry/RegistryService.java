package cn.huayq.registry;

import java.net.InetSocketAddress;

/**
 * @Author: huangyiqiang
 * @Description: 注册中心服务
 * @Date: Created in 11:04 2024/4/2
 */
public interface RegistryService {

    /**
     * 服务注册
     * @param serviceName       服务名
     * @param inetSocketAddress ip+port
     */
    void registry(String serviceName, InetSocketAddress inetSocketAddress);

    /**
     * 服务发现
     * @return ip+port
     */
    InetSocketAddress discovery();
}
