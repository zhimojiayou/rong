package com.wf.rong.service.concurrent;

import sun.misc.Unsafe;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zhimo
 * @create 2020-05-28 17:16
 */
public class Product {
    private Random random = new Random();

    public void handle(Unsafe unsafe, Thread thread) {
        ConcurrentLinkedHashQueueSingleton linkedHashQueueSingleton = ConcurrentLinkedHashQueueSingleton.getInstance();
        int count = 100;
        while (true) {
            try{
                int value = random.nextInt(7);
                linkedHashQueueSingleton.add("currentValue is " + value);
                if(thread != null){
                    unsafe.unpark(thread);
                }

                //TimeUnit.SECONDS.sleep(value);
                if(--count < 0){
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
