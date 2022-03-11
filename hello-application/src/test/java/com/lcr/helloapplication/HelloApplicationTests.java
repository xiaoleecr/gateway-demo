package com.lcr.helloapplication;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class HelloApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        System.out.println(m1());
    }

    public static String m1() {
        try {
            log.info("return");
            return "return";
        } catch (Exception e) {
            log.info("catch");
            return "catch";
        } finally {
            log.info("finally");
        }
    }
}
