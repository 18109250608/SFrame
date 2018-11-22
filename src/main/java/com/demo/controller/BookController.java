package com.demo.controller;


import com.demo.entity.Book;
import com.demo.entity.Project;
import com.demo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookMapper bm;

    @RequestMapping("/test")
    @ResponseBody
    public String toBookIndex(HttpServletRequest request, Model model){

        return "Hi, I'm Book! Nice to meet you~";
    }

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
        int ret = bm.insert(4,"1004", "月亮与六便士", (float) 20.3);
        return book;
    }

}
