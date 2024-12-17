package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컨트롤러의 기능을 수행
public class HelloController {
    // hello url 요청 발생시 hello 메서드 실행
    // 매핑이란 특정 url 경로를 서버에 특정 메서드와 연결
    @GetMapping("/hello")
    // 출력 결과가 문자열 그 자체
    @ResponseBody
    public String hello(){
        return "Hello Spring Boot Board";
    }
}
