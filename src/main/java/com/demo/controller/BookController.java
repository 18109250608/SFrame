package com.demo.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.Book;
import com.demo.entity.Project;
import com.demo.mapper.BookMapper;
import com.demo.vo.BookCategroyVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/book")
@Api(value="书籍接口",tags={"对书籍的相关操作"})
public class BookController {
    @Autowired
    private BookMapper bm;

    @ApiOperation(value="测试", notes="测试显示文字")
    @RequestMapping("/test")
    @ResponseBody
    public String toBookIndex(HttpServletRequest request, Model model){

        return "Hi, I'm Book! Nice to meet you~ 合作愉快。我创建了一个分支呢，你看看";
    }

    @ApiOperation(value="获取书籍详细信息", notes="根据书籍的id来获取书籍详细信息")
    @ApiImplicitParam(name = "id", value = "书籍ID", required = true,paramType = "query", dataType = "Integer")
    @RequestMapping("/test1")
    @ResponseBody
    public String toBookIndex1(HttpServletRequest request, Model model){
        Book book = bm.selectByPrimaryKey(1);
        return book.getName();
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    @ResponseBody
    public Float toBookIndex2(HttpServletRequest request, Model model){
        Book book = bm.selectByName("乌合之众");
        return book.getPrice();
    }

    @RequestMapping(value = "/test3", method = RequestMethod.POST)
    @ResponseBody
    public Book toBookIndex3(@RequestBody Book book, Model model){
//        int ret = bm.insert(book.getNo(), book.getName(), book.getPrice());
        String bookName = "花花草草";
        Book ibook = new Book();
        ibook.setName(bookName);
        ibook.setNo("1007");
        ibook.setPrice((float) 20.3);
        bm.insert(book);
        return book;
    }

//    @RequestMapping(value = "/test4", method = RequestMethod.POST)
//    @ResponseBody
//    public ResultVo getBookByCategory(@RequestBody String category, Model model){
//        Page<Map> mp = new Page<>()
//
//        return new BookCategroyVo();
//    }



}
