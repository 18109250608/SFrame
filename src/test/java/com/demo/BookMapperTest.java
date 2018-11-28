package com.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.Book;
import com.demo.mapper.BookMapper;
import com.demo.vo.BookCategroyVo;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Map;

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
//    @Ignore("not ready yet")
    @Test
    @Rollback
    public void testInsert() throws Exception {
        String bookName = "浮生六记";
        Book book = new Book();
        book.setName(bookName);
        book.setNo("1009");
        book.setCategoryId(1);
        book.setPrice((float) 19.3);
        bookMapper.insert(book);
        Book u = bookMapper.selectByName(bookName);
        Assert.assertSame("增加数据成功",40.4, u.getPrice());
    }

    @Test
    @Rollback
    public void testSelectOne() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "饥饿的盛世");

        Book book = bookMapper.selectOne(queryWrapper);
        System.out.println(book);
    }

    @Test
    @Rollback
    public void testSelectCount() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "镜花缘");

        Integer count = bookMapper.selectCount(queryWrapper);
        System.out.println(count);
    }

    @Test
    @Rollback
    public void testSelectList() {
        List<Book> list = bookMapper.selectList(null);

        System.out.println(list);
    }

    @Test
    @Rollback
    public void testSelectMaps() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("name");
        List<Map<String, Object>> maps = bookMapper.selectMaps(queryWrapper);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    @Test
    @Rollback
    public void testSelectPage() {
        Page<Book> page = new Page<>(1, 2);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();

        IPage<Book> bookIPage = bookMapper.selectPage(page, queryWrapper);
        System.out.println(bookIPage);
    }

    @Test
    @Rollback
    public void testSelectMapsPage() {
        Page<Book> page = new Page<>(1, 2);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "花");

        IPage<Map<String, Object>> mapIPage = bookMapper.selectMapsPage(page, queryWrapper);
        System.out.println(mapIPage);
    }

    @Test
    @Rollback
    public void testUpdate() {
        //修改值
        Book book = new Book();
        book.setName("哈哈镜花缘");

        //修改条件s
        UpdateWrapper<Book> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("no", "1006");

        int update = bookMapper.update(book, userUpdateWrapper);
        System.out.println(update);
    }


    @Test
    @Rollback
    public void testSelectBookByCategory() {
        Page<BookCategroyVo> page = new Page<>(2,3);
        IPage<BookCategroyVo> bookIPage = bookMapper.selectBookByCategory(page, "社会");
        System.out.println(bookIPage);
    }

}
