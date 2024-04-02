package cn.huayq.common.exception;

/**
 * @Author: huangyiqiang
 * @Description: 自定义异常
 * @Date: Created in 16:46 2024/4/2
 */
public class HuaRpcException extends RuntimeException{

    public HuaRpcException(){
        super();
    }

    public HuaRpcException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
