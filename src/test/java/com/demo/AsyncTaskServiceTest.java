package com.demo;

import com.demo.service.AsyncTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTaskServiceTest {

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void threadTest() throws Exception {
        for (int i = 0; i < 20; i++) {
            asyncTaskService.executeAsyncTask(i);
        }

        long start = System.currentTimeMillis();
        Future<String> task1 = asyncTaskService.doTaskOne();
        Future<String> task2 = asyncTaskService.doTaskTwo();
        Future<String> task3 = asyncTaskService.doTaskThree();
        while(true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

}

