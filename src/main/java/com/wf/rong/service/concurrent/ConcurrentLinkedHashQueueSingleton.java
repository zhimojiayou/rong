package com.wf.rong.service.concurrent;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author zhimo
 * @create 2020-05-28 17:03
 */
public class ConcurrentLinkedHashQueueSingleton extends ConcurrentLinkedDeque<String> {

    private ConcurrentLinkedHashQueueSingleton(){}

    private static class Singleton{
        private static final ConcurrentLinkedHashQueueSingleton CONCURRENT_LINKED_HASH_QUEUE_SINGLETON = new ConcurrentLinkedHashQueueSingleton();
    }

    public static ConcurrentLinkedHashQueueSingleton getInstance() {
        return Singleton.CONCURRENT_LINKED_HASH_QUEUE_SINGLETON;
    }
}
