package com.demo;

import com.demo.entity.Book;
import com.demo.mapper.BookMapper;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;

public class BookMapperTest extends DemoApplicationTests {

    @Autowired
    private BookMapper bookMapper;

    @Test
    @Rollback
    public void testGetBookList() throws Exception {
        List<Book> list = bookMapper.getBookList();
        System.out.println("读取在库书籍：");
        System.out.println(list);
    }

    @Test
    @Rollback
    public void testSelectByName() throws Exception {
        Book u = bookMapper.selectByName("饥饿的盛世");
        Assert.assertSame("获得书籍价格",(Object)20.7, (Object)u.getPrice());
    }

    // 忽略注解, 可以忽略方法，也可以忽略类哦~~
    @Ignore("not ready yet")
    @Test
    @Rollback
    public void testInsert() throws Exception {
        String bookName = "只有医生知道";
        bookMapper.insert(5,"1003", bookName, (float) 30.4);
        Book u = bookMapper.selectByName(bookName);
        Assert.assertSame("增加数据成功",30.4, u.getPrice());
    }



}
