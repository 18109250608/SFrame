package com.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
    List<Book> getBookList();

    Book selectByPrimaryKey(Integer id);

    Book selectByName(String name);

//    @Select("SELECT * FROM BOOK WHERE NAME = #{name}")
//    Book findByName(@Param("name") String name);
//
//    @Insert("INSERT INTO BOOK(NO, NAME, PRICE) VALUES(#{no}, #{name}, #{price})")
    int insert(@Param("id") int id,
               @Param("no") String no,
               @Param("name") String name,
               @Param("price") Float price);

}
