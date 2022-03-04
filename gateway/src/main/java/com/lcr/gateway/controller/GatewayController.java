package com.lcr.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GatewayController
 * @Description
 * @Author licongrui
 * @Date 2022/1/17
 */
@RestController
public class GatewayController {
    @GetMapping("/gatewaydemo")
    public String m1(){
        return "this is gateway";
    }
}
