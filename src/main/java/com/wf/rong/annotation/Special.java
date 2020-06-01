package com.wf.rong.annotation;

import org.springframework.stereotype.Component;

/**
 * @author zhimo
 * @create 2020-02-20 17:39
 */
@Component
public class Special {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Special{" +
                "name='" + name + '\'' +
                '}';
    }

    String name;

}
