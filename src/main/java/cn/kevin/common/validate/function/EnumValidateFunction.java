package cn.kevin.common.validate.function;

/**
 * enum validate function
 * created by yongkang.zhang
 * added at 2017/11/3
 */
public interface EnumValidateFunction {

    default Object applyDefault(Enum value) {
        return value.name();
    }

    Object apply(Enum value);

    /**
     * function的一些配置
     */
    default void init() {}
}
