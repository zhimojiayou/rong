package com.wf.rong.test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;

/**
 * @Auther: wenfu
 * @Date: 2021/5/27 18:01
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test.class.getMethod("test", Map.Entry.class);
        Type[] types = method.getGenericParameterTypes();
        for (Type type : types) {
            System.out.println("原始类型：" + type.toString());
            ParameterizedType parameterizedType = (ParameterizedType) type;
            System.out.println("type: " + parameterizedType + ", ownerType: " + parameterizedType.getOwnerType() + "," +
                    " " +
                    "rawType: " + parameterizedType.getRawType() + ", actualTypeArguments: " + Arrays.toString(parameterizedType.getActualTypeArguments()));
        }
    }

    public static <T, U> void test(Map.Entry<T, U> mapEntry) {

    }
}
