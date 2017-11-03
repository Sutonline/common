package cn.kevin.common.function;

import cn.kevin.common.validate.KeyInterface;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * 枚举function
 * created by yongkang.zhang
 * added at 2017/11/3
 */
public class EnumFunction {

    public static <E extends Enum<E> & KeyInterface> Optional<E> findByKey(Object key, Class<E> clazz) {
        return Arrays.stream(clazz.getEnumConstants()).filter(e -> Objects.equals(e.getKey(), key)).findFirst();
    }

}
