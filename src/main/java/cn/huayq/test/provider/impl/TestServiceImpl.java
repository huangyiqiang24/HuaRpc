package cn.huayq.test.provider.impl;

import cn.huayq.annotation.HuaRpcService;
import cn.huayq.test.provider.TestService;
import org.springframework.stereotype.Component;

/**
 * @Author: huangyiqiang
 * @Description:
 * @Date: Created in 14:26 2024/4/3
 */
@HuaRpcService
public class TestServiceImpl implements TestService {

    @Override
    public void say() {
        System.out.println("hello");
    }

}
