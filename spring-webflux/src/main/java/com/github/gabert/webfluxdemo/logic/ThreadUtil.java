package com.github.gabert.webfluxdemo.logic;

public class ThreadUtil {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
