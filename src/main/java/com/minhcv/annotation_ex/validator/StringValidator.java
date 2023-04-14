package com.minhcv.annotation_ex.validator;

import com.minhcv.annotation_ex.StringEx;
import com.minhcv.annotation_ex.annotation.NeverNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;

public class StringValidator {
    public void validate(StringEx stringEx) throws Exception {
        Field[] fields = StringEx.class.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            field.setAccessible(true);
            Object val = field.get(stringEx);
            for (Annotation annotation : annotations) {
                if (annotation instanceof NeverNull) {
                    if (Objects.isNull(val)) {
                        throw new Exception(((NeverNull) annotation).msg());
                    }
                }
            }
            System.out.println(annotations);
        }
    }
}
