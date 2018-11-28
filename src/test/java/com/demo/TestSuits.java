package com.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// 所有测试类打包到这个地方，只运行该测试类即可进行全部测试
@RunWith(Suite.class)
@Suite.SuiteClasses({BookMapperTest.class, BookControllerTest.class,
        StudentMapperTest.class})
public class TestSuits {

    //不用写代码，只需要注解即可
}

