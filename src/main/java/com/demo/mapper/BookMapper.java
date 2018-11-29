package com.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.Book;
import com.demo.vo.BookCategroyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookMapper extends BaseMapper<Book> {
    List<Book> getBookList();

    Book selectByPrimaryKey(Integer id);

    Book selectByName(String name);

    // 多表联合查询
    // 多参数情况下要加@Param说明
    IPage<BookCategroyVo> selectBookByCategory(Page<BookCategroyVo> page,
                                              @Param("name") String categoryName);


}
