package com.wf.rong.annotation;

import org.springframework.stereotype.Component;

/**
 * @author zhimo
 * @create 2020-02-20 17:39
 */
@Component
public class SpecialImpl extends Special implements BaseI, ServiceI   {
    @Override
    public String getBaseName() {
        return "specialBase";
    }

    @Override
    public String getService() {
        return "specialService";
    }
}
