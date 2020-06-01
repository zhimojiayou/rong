package com.wf.rong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhimo
 * @create 2019-12-06 15:00
 */
@Controller
@RequestMapping("/")
public class ThymeleafController {
    @GetMapping("/thymeleaf")
    public String hello(HttpServletRequest request, @RequestParam(value = "description", required = false, defaultValue = "springboot-thymeleaf") String description) {
        request.setAttribute("description", description);
        return "thymeleaf";
    }

    @GetMapping("/attributes")
    public String attributes(ModelMap map) {
        // 更改 h1 内容
        map.put("title", "Thymeleaf 标签演示");
        // 更改 id、name、value
        map.put("th_id", "thymeleaf-input");
        map.put("th_name", "thymeleaf-input");
        map.put("th_value", "13");
        // 更改 class、href
        map.put("th_class", "thymeleaf-class");
        map.put("th_href", "http://13blog.site");
        return "attributes";
    }

    @GetMapping("/simple")
    public String simple(ModelMap map) {
        map.put("thymeleafText", "wenfu");
        map.put("number1", "2019");
        map.put("number2", "3");
        return "simple";
    }

    @GetMapping("/testGrammar")
    public String test(ModelMap map) {
        map.put("title", "Thymeleaf 语法测试");
        map.put("testString", "wenfuSdFF123");
        map.put("testBool", true);
        map.put("testArrays", new Integer[]{1000, 23, 5, 245});
        map.put("testList", Arrays.asList("Spring", "Value", "boot", "zhimo"));
        Map testMap = new HashMap(16);
        testMap.put("platform", "zhimo");
        testMap.put("title", "测试用");
        testMap.put("result", "hhhh");
        map.put("testMap", testMap);
        map.put("testDate", new Date());
        return "test";
    }
}