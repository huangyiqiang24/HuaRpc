package cn.huayq.registry.zk;

import cn.huayq.common.util.ZkUtil;
import cn.huayq.registry.RegistryService;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;


/**
 * @Author: huangyiqiang
 * @Description: zk服务注册与发现
 * @Date: Created in 13:45 2024/4/2
 */
@Component
public class ZkRegistryServiceImpl implements RegistryService {

    /**
     * 服务注册
     * @param serviceName       服务名
     * @param inetSocketAddress ip+port
     */
    @Override
    public void registry(String serviceName, InetSocketAddress inetSocketAddress) {
        String root = ZkUtil.ZK_REGISTER_ROOT_PATH + serviceName;
        String child = root + inetSocketAddress.toString();
        CuratorFramework zkClient = ZkUtil.getZkClient();
        ZkUtil.createNodes(zkClient, root, child);
    }

    /**
     * 服务发现
     * @return ip+port
     */
    @Override
    public InetSocketAddress discovery() {
        return null;
    }
}
