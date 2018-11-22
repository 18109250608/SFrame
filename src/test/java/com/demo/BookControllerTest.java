package com.demo;

import com.demo.controller.BookController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class BookControllerTest extends DemoApplicationTests {
//    @Value("${msgStart}")
//    private String msgStart;
//
//    @Value("${msgEnd}")
//    private String msgEnd;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        //初始化
        mvc = MockMvcBuilders.standaloneSetup(new BookController()).build();
    }

    @Test
    public void hello() throws Exception {
        String url = "/book/test";//访问url
        String expectedResult = "Hi, I'm Book!886";//预期返回结果
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                                                                .accept(MediaType.APPLICATION_JSON))
                                    .andReturn();
        // 访问返回状态
        int status = mvcResult.getResponse().getStatus();
        // 接口返回结果
        String content = mvcResult.getResponse().getContentAsString();
//        // 打印结果和状态
//        System.out.println(status);
//        System.out.println(content);
        // 断言预期结果和状态
        Assert.assertTrue("正确", status == 200);
        Assert.assertFalse("错误", status != 200);
        Assert.assertTrue("数据一致", expectedResult.equals(content));
        Assert.assertFalse("数据不一致", !expectedResult.equals(content));
   }

}
