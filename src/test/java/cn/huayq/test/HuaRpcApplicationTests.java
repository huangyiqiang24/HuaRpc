package cn.huayq.test;

import cn.huayq.Application;
import cn.huayq.test.provider.impl.TestServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class HuaRpcApplicationTests {

    @Resource
    private TestServiceImpl testService;

    @Test
    void contextLoads() {

    }

}
