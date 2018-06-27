package com.liulei.springboot.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liulei.springboot.mapper.CategoryMapper;
import com.liulei.springboot.pojo.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Api()
用于类；表示标识这个类是swagger的资源
tags–表示说明
value–也是说明，可以使用tags替代
 */
@Api(value = "springboot+jsp测试controller")
@RestController
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;
    /**
     * @ApiOperation() 用于方法；表示一个http请求的操作
        value用于方法描述
     notes用于提示内容
     tags可以重新分组（视情况而用）
     */
    /**
     * 查询
     * @param model
     * @return
     */
    @RequestMapping("/listCategory")
    @ApiOperation(value = "显示列表信息",notes = "在参数里接受当前是第几页 start ，以及每页显示多少条数据 size。 默认值分别是0和5")
    public  String listCategory(Model model, @RequestParam(value = "start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size){

        //根据start,size进行分页，并且设置id 倒排序
        PageHelper.startPage(start,size,"id desc");
        List<Category> cs=categoryMapper.findAll();
        //返回的集合，创建PageInfo对象
        PageInfo<Category> page = new PageInfo<>(cs);
        model.addAttribute("page", page);

        return "listCategory";

    }
    /**
     * @ApiModel()用于类 ；表示对类进行说明，用于参数用实体类接收
    value–表示对象名
    description–描述
    都可省略
     */


    @ApiOperation(value = "新增category表")
    @RequestMapping("/addCategory")
    public String addCategory(@ApiParam(name="用户对象",value="传入json格式",required=true) Category category ){
        categoryMapper.save(category);
        return  "redirect:listCategory";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteCategory")
    public  String deleteCategory(int id){
        categoryMapper.delete(id);
        return  "redirect:listCategory";
    }

    /**
     * 根据ID查
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/categoryById")
    public  String categoryById(int id,Model model){
        Category  c = categoryMapper.categoryById(id);
        model.addAttribute(c);
        return "editCategory";

    }

    /**
     * 修改
     * @param category
     * @return
     */
    @RequestMapping("/updateCategory")
    public String updateCategory(Category category){
        categoryMapper.updateCategory(category);
        return "redirect:listCategory";
    }
}
