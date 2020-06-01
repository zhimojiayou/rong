package com.wf.rong.service.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * @author zhimo
 * @create 2020-05-28 17:24
 */
public class Test {

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Unsafe unsafe = Test.reflectGetUnsafe();
        Thread consumer = new Thread(() -> {
           Consumer c = new Consumer();
           c.handle(unsafe);
        });

        Thread product = new Thread(() -> {
            Product p = new Product();
            p.handle(unsafe, consumer);
        });

        consumer.start();
        //TimeUnit.SECONDS.sleep(2L);
        product.start();
    }
}
