package com.demo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.service.IBookService;
import com.demo.vo.BookCategroyVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;


public class BookServiceTest extends DemoApplicationTests{

    @Autowired
    private IBookService ibs;

    @Test
    @Rollback
    public void testSelectBookByCategory() throws Exception {
        Page<BookCategroyVo> page = new Page<>(1,3);
        IPage<BookCategroyVo> ipage = ibs.selectBookByCategory(page, "社会");
        System.out.println(ipage);
    }
}
