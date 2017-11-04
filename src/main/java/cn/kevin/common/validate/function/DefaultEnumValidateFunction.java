package cn.kevin.common.validate.function;

import cn.kevin.common.exception.NotSupportException;
import cn.kevin.common.validate.KeyInterface;

/**
 * 默认的枚举验证器
 * created by yongkang.zhang
 * added at 2017/11/3
 */
public class DefaultEnumValidateFunction implements EnumValidateFunction {

    @Override
    public Object apply(Enum value) {
        if (KeyInterface.class.isAssignableFrom(value.getClass())) {
            return ((KeyInterface) value).getKey();
        }

        throw new NotSupportException("using DefaultEnumValidateFunction requires enum implements KeyInterface.");
    }
}
