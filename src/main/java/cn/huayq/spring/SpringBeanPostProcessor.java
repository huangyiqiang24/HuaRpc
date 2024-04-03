package cn.huayq.spring;

import cn.huayq.annotation.HuaRpcService;
import cn.huayq.config.RpcServiceConfig;
import cn.huayq.service.ProviderService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: huangyiqiang
 * @Description:
 * @Date: Created in 14:09 2024/4/3
 */
@Component
public class SpringBeanPostProcessor implements BeanPostProcessor {

    @Resource
    private ProviderService providerService;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(HuaRpcService.class)) {
            HuaRpcService rpcService = bean.getClass().getAnnotation(HuaRpcService.class);
            // build RpcServiceProperties
            RpcServiceConfig rpcServiceConfig = new RpcServiceConfig()
                    .setVersion(rpcService.version())
                    .setService(bean);
            providerService.publishService(rpcServiceConfig);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
