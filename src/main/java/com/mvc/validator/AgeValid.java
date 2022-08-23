package com.mvc.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = AgeValidImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeValid{

    public String message() default "Invalid Age! Minimum shoud be 18y";
    public String fomart() default "yyyyMMdd";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
