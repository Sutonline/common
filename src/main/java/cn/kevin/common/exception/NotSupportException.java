package cn.kevin.common.exception;

/**
 * 不支持的枚举类型
 * created by yongkang.zhang
 * added at 2017/11/3
 */
public class NotSupportException extends RuntimeException {

    public NotSupportException() {
        super();
    }

    public NotSupportException(String message) {
        super(message);
    }

}
