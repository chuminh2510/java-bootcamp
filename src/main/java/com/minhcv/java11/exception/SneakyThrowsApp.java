package com.minhcv.java11.exception;

import java.io.IOException;

public class SneakyThrowsApp {
    public static <E extends Throwable> void sneakyThrow(Throwable e) throws E {
        throw (E) e;
    }

    // Sneaky throw: No need to define exception at method name
    public static void throwSneakyIOException() {
        sneakyThrow(new IOException("Sneaky IO"));
    }

    public static void main(String[] args) {
        try {
            throwSneakyIOException();
            System.out.println("SneakyThrowsApp.main: No more");
        } catch (Exception ex) {
            System.out.println("SneakyThrowsApp.main: " + ex.getMessage());
        }
    }
}
