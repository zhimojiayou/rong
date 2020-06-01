package com.wf.rong.controller;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhimo
 * @create 2019-10-16 9:10
 */
public class CglibTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.resolve("wf", 30);
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println(">>>>before interceptor");
                System.out.println("who is this class : " + getClass());
                methodProxy.invokeSuper(o, objects);
                System.out.println(">>>>end interceptor");
                return o;
            }
        };
        Person tmp = (Person) Enhancer.create(Person.class, methodInterceptor);
        tmp.resolve("tmp", 50);
    }
}
