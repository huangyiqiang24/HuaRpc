package cn.huayq.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @Author: huangyiqiang
 * @Description:
 * @Date: Created in 14:12 2024/4/3
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Service
public @interface HuaRpcService {

    String version() default "";

}
