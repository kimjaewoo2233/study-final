package com.example.demo.controller;


import com.example.demo.RestTestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {


    private final RestTestTemplate restTestTemplate;
    @GetMapping("/test")
    public ResponseEntity<Boolean> test(){
        return ResponseEntity.ok(true);
    }


    @GetMapping("/code")
    public ResponseEntity<String> test(@RequestParam String code){
        log.info("토큰 발행 포인트");
        restTestTemplate.requestBand(code);
        return ResponseEntity.ok("code");
    }

}
