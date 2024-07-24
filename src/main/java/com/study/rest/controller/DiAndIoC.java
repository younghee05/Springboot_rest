package com.study.rest.controller;

import com.study.rest.di.A;
import com.study.rest.di.B;
import com.study.rest.di.C;
import com.study.rest.di.D;
import com.study.rest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiAndIoC {

    @Autowired
    private C c;

    @Autowired
    private D d;

    @Autowired
    @Qualifier("ts")
    private TestService testService1;

    @Autowired
    @Qualifier("newTestServiceImpl")
    private TestService testService2;

    @ResponseBody
    @GetMapping("/di")
    public Object di() {
        // A가 B를 의존하는 관계 (결합도는 낮은 상태)
        B b = new B();
        A a = new A(b);
        a.aCall();
        return null;
    }

    @ResponseBody
    @GetMapping("/ioc")
    public Object ioc() {
        d.dCall();
        return null;
    }

    @ResponseBody
    @GetMapping("/test")
    public Object startTest(@RequestParam String type) {
        if("old".equals(type)) {
            testService1.test();
        } else {
            testService2.test();
        }
//        System.out.println(type);
        return null;
    }
}
