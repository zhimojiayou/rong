package com.wf.rong.service.concurrent;

import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;
import sun.misc.Unsafe;

/**
 * 消费者
 *
 * @author zhimo
 * @create 2020-05-28 17:06
 */
public class Consumer {
    public void handle(Unsafe unsafe){
        ConcurrentLinkedHashQueueSingleton linkedHashQueueSingleton = ConcurrentLinkedHashQueueSingleton.getInstance();
        while (true) {
            if (!linkedHashQueueSingleton.isEmpty()) {
                System.out.println(linkedHashQueueSingleton.poll());
            }else {
                unsafe.park(false, 0);
            }
        }
    }
}
