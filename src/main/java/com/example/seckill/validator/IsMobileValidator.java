package com.example.seckill.validator;

//isMobile注解的手机号校验规则

import com.example.seckill.utils.ValidatorUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

//    false：默认设定为允许空值
    private boolean required = false;

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required){
            return ValidatorUtil.isMobile(value);
        }else {
            if (StringUtils.isEmpty((value)))
                return true;
            else
                return ValidatorUtil.isMobile(value);
        }
        }
    }
