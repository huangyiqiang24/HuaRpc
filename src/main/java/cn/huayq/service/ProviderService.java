package cn.huayq.service;

import cn.huayq.config.RpcServiceConfig;

/**
 * @Author: huangyiqiang
 * @Description:
 * @Date: Created in 13:38 2024/4/3
 */
public interface ProviderService {

    /**
     * 发布服务
     * @param rpcServiceConfig rpc服务配置
     */
    void publishService(RpcServiceConfig rpcServiceConfig);

}
