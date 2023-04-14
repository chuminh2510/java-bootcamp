package com.minhcv.annotation_ex.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TrimString {
    String value();

    String des() default "Not described yet";
}
