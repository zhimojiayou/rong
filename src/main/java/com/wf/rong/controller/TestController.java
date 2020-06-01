package com.wf.rong.controller;

import com.wf.rong.annotation.BaseI;
import com.wf.rong.annotation.ServiceI;
import com.wf.rong.annotation.Special;
import com.wf.rong.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试
 *
 * @author zhimo
 * @create 2019-09-23 16:10
 */
@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private List<Special> list;
    @Autowired
    private Map<String, ServiceI> map;
    @RequestMapping(value = "/test", method = {RequestMethod.POST, RequestMethod.GET})
    public String timeCommand() {
        System.out.println(list.get(0));
        System.out.println(map.toString());
        return "success!";
    }

    @RequestMapping(path="/typeConversionTest")
    public void typeConversionTest(String goodsName, float weight, int type, Boolean onSale){
        System.out.println("goodsName:" + goodsName);
        System.out.println("weight:" + weight);
        System.out.println("type:" + type);
        System.out.println("onSale:" + onSale);
    }

    @RequestMapping(path = "/httpMessageConvertTest", method = RequestMethod.POST)
    //@ResponseBody
    public Student httpMessageConvertTest(@RequestBody Student student) {
        student.setAge(33);
        student.setName("zhangsan");
        return student;
    }


}
