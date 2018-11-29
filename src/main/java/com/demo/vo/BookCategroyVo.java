package com.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(description = "带类别的书籍实体")
@Data
public class BookCategroyVo implements Serializable {
    @ApiModelProperty(required = true, notes = "id")
    private Integer id;

    @ApiModelProperty(notes = "书籍编号", example = "1010")
    private String no;

    @ApiModelProperty(notes = "书籍名称", example = "C++ Primer")
    private String name;

    @ApiModelProperty(notes = "书籍价格", example = "11.11")
    private Float price;

    @ApiModelProperty(notes = "书籍类别", example = "社会")
    private String categoryName;

}
