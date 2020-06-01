package com.wf.rong;

import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.wf.rong.annotation.Special;
import com.wf.rong.redis.RedisDelayingQueue;
import com.wf.rong.service.DataHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class RongApplication {

    //@Autowired
    //private Map<String, BaseI> map;

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext beanFactory = SpringApplication.run(RongApplication.class, args);
        DataHandler dataHandler = (DataHandler) beanFactory.getBean("dataHandler");
        Special special = new Special();
        special.setName("111");
        dataHandler.handle(special, 22, "测试");
        //handleRateLimiter();
        //SpringApplication springApplication = new SpringApplication(RongApplication.class);
        //springApplication.setWebApplicationType(WebApplicationType.SERVLET);
        //springApplication.setBannerMode(Banner.Mode.CONSOLE);
        //springApplication.run(args);

        //RedisDelayingQueue redisDelayingQueue = (RedisDelayingQueue) beanFactory.getBean("redisDelayingQueue");
        //handleDelayQueue(redisDelayingQueue);

    }

    private static void handleDelayQueue(RedisDelayingQueue queue) {
        Thread producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    queue.delay("codehole" + i);
                }
            }
        };
        Thread consumer = new Thread() {
            @Override
            public void run() {
                queue.loop();
            }
        };
        producer.start();
        consumer.start();
        try {
            producer.join();
            Thread.sleep(6000);
            consumer.interrupt();
            consumer.join();
        } catch (InterruptedException e) {
        }
    }

    @Bean
    public RedisDelayingQueue redisDelayingQueue() {
        RedisDelayingQueue<String> queue = new RedisDelayingQueue<>("q-demo");
        return queue;
    }

    private static void handleRateLimiter() throws InterruptedException {
        // qps设置为5，代表一秒钟只允许处理五个并发请求
        RateLimiter rateLimiter = RateLimiter.create(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        int nTasks = 20;
        CountDownLatch countDownLatch = new CountDownLatch(nTasks);
        long start = System.currentTimeMillis();
        for (int i = 0; i < nTasks; i++) {
            final int j = i;
            executorService.submit(() -> {
                rateLimiter.acquire(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println(new ThreadFactoryBuilder().setNameFormat("handleRateLimiter-%d").build() + " gets job " + j + " done");
                countDownLatch.countDown();
            });
        }
        executorService.shutdown();
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("10 jobs gets done by 5 threads concurrently in " + (end - start) + " milliseconds");
    }

}
