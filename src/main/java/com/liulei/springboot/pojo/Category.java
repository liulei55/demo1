package com.liulei.springboot.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
 * @ApiModelProperty()用于方法，字段； 表示对model属性的说明或者数据操作更改
 */
@ApiModel(value = "category对象",description = "这是一段描述")
public class Category implements Serializable{

    private int id;
    @ApiModelProperty(value="姓名",name="name",example="王五")
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
