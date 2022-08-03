package com.minhcv.java11.architectures_test.service;

import com.minhcv.java11.architectures_test.controller.SomethingController;

public class UserService {
    public void doSomething() {
        SomethingController controller = new SomethingController();
        controller.specifyType();
    }
}
