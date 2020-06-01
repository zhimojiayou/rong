package com.wf.rong.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

/**
 * @author zhimo
 * @create 2020-02-20 17:36
 */
@Component("oneImpl")
public class OneImpl implements BaseI, ServiceI {
    @Override
    public String getBaseName() {
        return "baseOne";
    }

    @Override
    public String getService() {
        return "serviceOne";
    }
}
