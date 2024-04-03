package cn.huayq.config;

/**
 * @Author: huangyiqiang
 * @Description: rpc服务配置
 * @Date: Created in 13:45 2024/4/3
 */
public class RpcServiceConfig {

    /**
     * 服务版本
     */
    private String version = "1.0";

    /**
     * target service
     */
    private Object service;

    public RpcServiceConfig(){}

    public RpcServiceConfig(String version, Object service){
        this.version = version;
        this.service = service;
    }

    /**
     *
     * @return rpc服务名
     */
    public String getRpcServiceName() {
        return this.getServiceName() + this.getVersion();
    }

    /**
     *
     * @return 全限定名
     */
    public String getServiceName() {
        return this.service.getClass().getInterfaces()[0].getCanonicalName();
    }

    public String getVersion() {
        return version;
    }

    public RpcServiceConfig setVersion(String version) {
        this.version = version;
        return this;
    }

    public Object getService() {
        return service;
    }

    public RpcServiceConfig setService(Object service) {
        this.service = service;
        return this;
    }
}
