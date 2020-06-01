package com.wf.rong.service;

import com.wf.rong.annotation.ReSend;
import com.wf.rong.annotation.Special;
import org.springframework.stereotype.Service;

/**
 * @author zhimo
 * @create 2020-05-06 15:31
 */
@Service
public class DataHandler {

    @ReSend("hello")
    public void handle(Special special, int num, String description) {
        System.out.println("special: " + special + " , num: " + num + " des: " + description);
    }
}
