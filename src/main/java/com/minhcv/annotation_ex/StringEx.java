package com.minhcv.annotation_ex;

import com.minhcv.annotation_ex.annotation.NeverNull;
import com.minhcv.annotation_ex.annotation.TrimString;

public class StringEx {
    @NeverNull(msg = "The initNull field must not null")
    String initNull;

    @NeverNull(msg = "The value field must not null")
    @TrimString(value = "MinhCvTest", des = "First test")
    String value;

    @TrimString(value = "Default des")
    String defaultDes;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDefaultDes() {
        return defaultDes;
    }

    public void setDefaultDes(String defaultDes) {
        this.defaultDes = defaultDes;
    }

    public String getInitNull() {
        return initNull;
    }

    public void setInitNull(String initNull) {
        this.initNull = initNull;
    }
}
