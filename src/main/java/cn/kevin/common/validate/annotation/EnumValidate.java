package cn.kevin.common.validate.annotation;

import cn.kevin.common.validate.function.DefaultEnumValidateFunction;
import cn.kevin.common.validate.function.EnumValidateFunction;
import cn.kevin.common.validate.validator.EnumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 枚举验证器
 * created by yongkang.zhang
 * added at 2017/11/3
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidator.class)
@Documented
public @interface EnumValidate {

    String message() default "enum corresponding to key is not found";

    /**
     * 是否对null值进行校验
     */
    boolean containsNull() default false;

    /**
     * an attribute payload that can be used by clients of the Bean Validation API to assign custom payload objects to a
     * constraint. This attribute is not used by the API itself.
     * 自定义payload，官方说明是可以根据payload的错误不一样实现对应的处理
     * @return payload
     */
    Class<? extends Payload>[] payload() default { };

    /**
     * 使用哪个枚举进行验证
     */
    Class<? extends Enum> enumClazz();

    /**
     * 这是个很有用的功能
     * 官方的说明是: 一个明显的例子是ui前面，先验证哪些信息，后验证哪些信息
     * 还有另外一个场景就是，不同业务对于不同的validate规则是不同的，所以就可以使用group tagging 他们
     * @return 在哪些组别下
     */
    Class<?>[] groups() default {};

    Class<? extends EnumValidateFunction> function() default DefaultEnumValidateFunction.class;
}
