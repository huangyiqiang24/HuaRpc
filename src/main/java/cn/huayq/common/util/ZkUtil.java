package cn.huayq.common.util;

import cn.huayq.common.exception.HuaRpcException;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;

/**
 * @Author: huangyiqiang
 * @Description: ZkUtil
 * @Date: Created in 13:59 2024/4/2
 */
public final class ZkUtil {

    public static final String ZK_REGISTER_ROOT_PATH = "/Hua-RPC/";

    /**
     * zk 客户端
     */
    private static CuratorFramework client;

    /**
     * 获取zk客户端
     */
    public static CuratorFramework getZkClient() {
        if (client == null || CuratorFrameworkState.LATENT.equals(client.getState())) {
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
                    .connectString("127.0.0.1")
                    .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                    .build();
            client.start();
        } catch (Exception e) {
            throw new HuaRpcException("ZK Connected Exception", e);
        }
    }

    /**
     * 创建节点
     * @param client 客户端
     * @param mode   节点类型
     * @param path   路径
     */
    public static void createNode(CuratorFramework client, CreateMode mode, String path) {
        try {
            client.create().creatingParentsIfNeeded().withMode(mode).forPath(path);
        } catch (KeeperException.NodeExistsException ignored) {

        } catch (Exception e) {
            throw new HuaRpcException("Created ZkNode Exception", e);
        }
    }

    /**
     * 创建永久节点
     * @param client 客户端
     * @param path   路径
     */
    public static void createPersistentNode(CuratorFramework client, String path) {
        createNode(client, CreateMode.PERSISTENT, path);
    }

    /**
     * 创建临时节点
     * @param client 客户端
     * @param path   路径
     */
    public static void createEphemeralNode(CuratorFramework client, String path) {
        createNode(client, CreateMode.EPHEMERAL, path);
    }

    /**
     * 创建多节点
     * @param client 客户端
     * @param parent 父节点
     * @param child  字子节点
     */
    public static void createNodes(CuratorFramework client, String parent, String child) {
        ZkUtil.createPersistentNode(client, parent);
        ZkUtil.createEphemeralNode(client, child);
    }

}
