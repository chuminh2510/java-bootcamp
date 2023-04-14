package com.minhcv.annotation_ex.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NeverNull {
    String msg() default "This field must not null";
}
