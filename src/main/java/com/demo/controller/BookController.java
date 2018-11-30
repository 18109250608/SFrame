package com.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.Book;
import com.demo.entity.Project;
import com.demo.mapper.BookMapper;
import com.demo.service.IBookService;
import com.demo.vo.BookCategroyVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("/book")
@Api(value="书籍接口",tags={"书籍相关API"})
public class BookController {
    @Autowired
    private BookMapper bm;

    @Autowired
    private IBookService ibs;

    @ApiOperation(value="测试", notes="测试显示文字")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String toBookIndex(HttpServletRequest request, Model model){

        return "Hi, I'm Book! Nice to meet you~ 合作愉快。我创建了一个分支呢，你看看";
    }

    @ApiOperation(value="获取书籍详细信息", notes="根据书籍的id来获取书籍详细信息")
    @ApiImplicitParam(name = "id", value = "书籍ID", required = true, paramType = "query", dataType = "Long")
    @RequestMapping(value = "/getBookInfoById", method = RequestMethod.GET)
    @ResponseBody
    public Book getBookInfoById(@RequestParam(value = "id", required = true) Integer id){
        Book book = bm.selectByPrimaryKey(id);
        return book;
    }


    @ApiOperation(value="获取书籍信息", notes="根据书籍名称获取书籍详细信息")
    @ApiImplicitParam(name = "name", value = "书籍名称", required = true,paramType = "query", dataType = "String")
    @RequestMapping(value = "/getBookInfoByName", method = RequestMethod.GET)
    @ResponseBody
    public Book getBookInfoByName(@RequestParam(value = "name", required = true) String name){
        Book book = bm.selectByName(name);
        return book;
    }


    @ApiOperation(value="新增书籍", notes="新增书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "book", value = "书籍实体Book，除去id", required = true, dataType = "Book")
    })
//    @ApiResponses({
//            @ApiResponse()
//    })
    @RequestMapping(value = "/insertBook", method = RequestMethod.POST)
    @ResponseBody
    public Integer insertBook(@RequestBody Book book, Model model){
        Integer index = bm.insert(book);
        return index;
    }


    @ApiOperation(value="按类别查询书籍", notes="按类别查询书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "书籍类别名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "current", value = "当前页编号（从1开始的编号）", required = false, dataType = "Long", defaultValue = "1"),
            @ApiImplicitParam(name = "count", value = "每页个数", required = false, dataType = "Long", defaultValue = "10")
    })
    @RequestMapping(value = "/getBookByCategory", method = RequestMethod.GET)
    @ResponseBody
    public IPage<BookCategroyVo> getBookByCategory(@RequestParam(value = "name", required = true) String name,
                                            @RequestParam(value = "current", required = false) Long current,
                                            @RequestParam(value = "count", required = false) Long count){
        Page<BookCategroyVo> page = new Page<>(current, count);
        IPage<BookCategroyVo> ipage = ibs.selectBookByCategory(page, name);
        return ipage;
    }



}
