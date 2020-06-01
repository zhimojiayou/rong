package com.wf.rong.config;

import com.wf.rong.annotation.ReSend;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zhimo
 * @create 2020-05-06 15:38
 */
@Aspect
@Component
public class ReSendAspect {

    @Pointcut("@annotation(com.wf.rong.annotation.ReSend)")
    public void noUse(){}

    @After(value = "noUse() && @annotation(reSend)")
    public void afterHandleReSend(JoinPoint joinPoint, ReSend reSend){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("reSend.value: " + reSend.value());
        Object[] objects = joinPoint.getArgs();
        for(Object obj : objects){
            System.out.println("   , " + obj);
        }
        System.out.println("后置通知结束");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
