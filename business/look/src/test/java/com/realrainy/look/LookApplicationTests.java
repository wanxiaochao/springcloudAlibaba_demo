package com.realrainy.look;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LookApplicationTests {

    @Test
    void contextLoads() {
    }

    static boolean y = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(){
            @Override
            public void run() {
                while (y){
                    System.out.println(1);
                }
                System.out.println(Thread.currentThread().getName()+"执行结束");
            }
        }.start();
        System.out.println(Thread.currentThread().getName()+"执行中");
        Thread.sleep(1000);
        y = false;
        System.out.println("主线程执行结束");

    }
}
