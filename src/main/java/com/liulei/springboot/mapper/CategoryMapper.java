package com.liulei.springboot.mapper;

import com.liulei.springboot.pojo.Category;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CategoryMapper {
    @ApiOperation("category集合查询")
    @Select("select * from category")
    public  List<Category> findAll();


    @Insert("insert into category ( name ) values (#{name})")
    public int save(Category category);

    /**
     * 删除
     * @param id
     */
    @Delete("delete from category where id=#{id}")
    public  void delete(int id);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Select("select * from category where id= #{id}")
    public Category categoryById(int id);

    /**
     * 修改
     * @param category
     * @return
     */
    @Update("UPDATE category  set name=#{name} where id=#{id}")
    public  int updateCategory(Category category);
}
