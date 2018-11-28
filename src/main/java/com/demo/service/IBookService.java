package com.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.vo.BookCategroyVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mzh
 * @since 2018-11-27
 */
public interface IBookService extends IService<Book> {

    IPage<BookCategroyVo> selectBookByCategory(Page<BookCategroyVo> page, String categoryName);
}
