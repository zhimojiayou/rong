package com.wf.rong.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author zhimo
 * @create 2020-02-20 17:37
 */
@Component("twoImpl")
@Qualifier("hello")
public class TwoImpl implements BaseI, ServiceI {
    @Override
    public String getBaseName() {
        return "baseTwo";
    }

    @Override
    public String getService() {
        return "serviceTwo";
    }
}
