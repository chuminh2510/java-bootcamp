package com.minhcv.annotation_ex;

import com.minhcv.annotation_ex.validator.StringValidator;

public class AnnotationApp {
    private static int longVal = 123_456_789;

    public static void main(String[] args) {
        System.out.println("AnnotationApp.main:: start");
        System.out.println("Long Value: " + longVal);
        StringEx stringEx = new StringEx();
        stringEx.setValue("Test");
        StringValidator validator = new StringValidator();

        try {
            validator.validate(stringEx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("AnnotationApp.main:: end");

    }

}
