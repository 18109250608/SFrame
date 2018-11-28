package com.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.Book;
import com.demo.mapper.BookMapper;
import com.demo.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.vo.BookCategroyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mzh
 * @since 2018-11-27
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public IPage<BookCategroyVo> selectBookByCategory(Page<BookCategroyVo> page, String categoryName) {
        IPage<BookCategroyVo> ipage= bookMapper.selectBookByCategory(page, categoryName);
        return ipage;
    }

}
