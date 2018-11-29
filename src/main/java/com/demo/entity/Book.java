package com.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author mzh
 * @since 2018-11-27
 */
@ApiModel(description = "书籍实体")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = true, notes = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(notes = "书籍编号", example = "1010")
    private String no;

    @ApiModelProperty(notes = "书籍名称", example = "C++ Primer")
    private String name;

    @ApiModelProperty(notes = "书籍价格", example = "11.11")
    private Float price;

    @ApiModelProperty(notes = "书籍类别id", example = "1")
    @TableField("category_id")
    private Integer categoryId;


}
