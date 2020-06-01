package com.wf.rong.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ReSend {

    /**
     *  用于测试
     * @param :
     * @return: java.lang.String
     * @author: zhimo
     * @Date: 2020-05-06 15:35:51
     */
    String value() default "";
}
