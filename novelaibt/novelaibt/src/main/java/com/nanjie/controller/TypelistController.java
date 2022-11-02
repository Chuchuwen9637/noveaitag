package com.nanjie.controller;


import com.nanjie.common.Result;
import com.nanjie.common.typeListDTO;
import com.nanjie.entity.Totaltype;
import com.nanjie.entity.Typelist;
import com.nanjie.entity.vo.typeList_vo;
import com.nanjie.mapper.TypelistMapper;
import com.nanjie.service.impl.TypelistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2022-10-14
 */
@RestController
@RequestMapping("/typelist")
public class TypelistController {
    @Autowired
    private TypelistMapper typelistMapper;
    @Autowired
    private TypelistServiceImpl typelistService;
    @RequestMapping("fidalltypelist")
    public Result fidalltypelist(){
        List<Typelist> list =typelistMapper.selectList(null);
        return Result.ok(200,"查询成功",list);
    }
    @RequestMapping("byidtypelist/{id}")
    public Result find_Byid_typelist(@PathVariable("id") int id){
        List<Typelist> list=typelistService.select_byId_typelist(id);
        return Result.ok(200,"查询成功",list);
    }
        @RequestMapping("find_byname")
    public Result find_typename(@RequestBody typeListDTO typeListdto){
     List<Typelist> list=  typelistService.select_byname__typelist(typeListdto.getTypename());
        return Result.ok(200,"list",list);
    }
    //返回分页信息
    @RequestMapping("get_count")
    public Result select_count(String name){
        return Result.ok(200,"查询分页成功",typelistService.select_typelist_count(name));
    }
    //返回模糊查询切分页的所有内容
    @RequestMapping("typelist_page_name")
    public Result find_page_list_byname(@RequestBody typeList_vo vo){
        System.out.println(vo);
        int page=(vo.getVal()-1)*15;
        vo.setPage(page);
        vo.setMaxlimitl(15);

        return Result.ok(200,"查询"+vo.getName(),typelistService.select_litem(vo));
    }
}
