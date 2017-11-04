package cn.kevin.common.enums;

import cn.kevin.common.validate.KeyInterface;

/**
 * 枚举类型验证
 * created by yongkang.zhang
 * added at 2017/11/4
 */
public enum BooleanTypeEnum implements KeyInterface {

    TRUE(1), FALSE(0);

    private Integer code;

    BooleanTypeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public Object getKey() {
        return code;
    }
}
