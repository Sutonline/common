package cn.kevin.enums;

import cn.kevin.common.enums.BooleanTypeEnum;
import cn.kevin.common.validate.KeyInterface;
import cn.kevin.common.validate.annotation.EnumValidate;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * 枚举有效测试
 * created by yongkang.zhang
 * added at 2017/11/4
 */
public class validateTest {

    @Test
    public void validate() throws Exception {
        TestDomain testDomain = new TestDomain();
        testDomain.setCode(null);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<TestDomain>> errorSet = validator.validate(testDomain);
        errorSet.forEach(System.out::println);
    }

    public static class TestDomain implements KeyInterface {

        @EnumValidate(enumClazz = BooleanTypeEnum.class, containsNull = true)
        private Integer code;

        void setCode(Integer code) {
            this.code = code;
        }

        @Override
        public Object getKey() {
            return code;
        }
    }



}
