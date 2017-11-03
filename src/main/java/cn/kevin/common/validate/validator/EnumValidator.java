package cn.kevin.common.validate.validator;

import cn.kevin.common.exception.NotSupportException;
import cn.kevin.common.validate.annotation.EnumValidate;
import cn.kevin.common.validate.function.EnumValidateFunction;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * 验证器
 * created by yongkang.zhang
 * added at 2017/11/3
 */
public class EnumValidator implements ConstraintValidator<EnumValidate, Object> {

    private Class<? extends EnumValidateFunction> function;

    private Class<? extends Enum> clazz;

    @Override
    public void initialize(EnumValidate constraintAnnotation) {
        this.function = constraintAnnotation.function();
        this.clazz = constraintAnnotation.enumClazz();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        final EnumValidateFunction curFunc;
        try {
            curFunc = function.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new NotSupportException("Function implements EnumvalidateFunction must has no args constructor");
        }
        curFunc.init();

        Optional<? extends Enum> foundEnum = Arrays.stream(clazz.getEnumConstants()).filter(e ->
                Objects.equals(curFunc.apply(e), value)).findFirst();

        return foundEnum.isPresent();
    }
}
