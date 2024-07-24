package com.study.rest.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C {

    @Autowired(required = false) // false나 true는 주입을 무조건 할 필요는 없다
    private D d;

    public void cCall() {
        System.out.println("C 객체에서 메소드 호출");
        d.dCall(); // 먼저 null 이들어가기 때문에 오류가 뜬다
    }
}
