package cn.huayq.common.util;

import cn.huayq.common.exception.HuaRpcException;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @Author: huangyiqiang
 * @Description:
 * @Date: Created in 13:59 2024/4/2
 */
public class ZkUtil {
    /**
     * zk 客户端
     */
    private static CuratorFramework client;

    /**
     * 获取zk客户端
     */
    public static CuratorFramework getZkClient() {
        if (client == null || !client.getZookeeperClient().isConnected()) {
            connect();
        }
        return client;
    }

    /**
     * 建立zk连接
     */
    private static void connect() {
        try {
            client = CuratorFrameworkFactory.builder()
                    .connectString("")
                    .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                    .build();
            client.start();
        } catch (Exception e) {
            throw new HuaRpcException("ZK Connected Exception", e);
        }
    }

}
