package com.nanjie.controller;


import com.nanjie.common.Result;
import com.nanjie.entity.Authortag;
import com.nanjie.mapper.AuthortagMapper;
import com.nanjie.service.impl.AuthortagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2022-10-16
 */
@RestController
@RequestMapping("/authortag")
public class AuthortagController {
    @Autowired
   private AuthortagServiceImpl authortagService;
    @Autowired
    private AuthortagMapper authortagMapper;
    @RequestMapping("savaauthor")
        public Result savaauthortag(@RequestBody Authortag authortag){
        System.out.println(authortag.toString());
        authortag.setSamplingSteps(50);
        if (authortag.getNegativetag().isEmpty()){
            return Result.ok(501,"tag不能为空",null);
        }
        int flag= authortagMapper.insert(authortag);
        return Result.ok(200,"添加成功",flag);
        }
        @RequestMapping("selecturl")
        public Result find_all_url(){
       List<String> list=authortagService.select_url_all();
        return Result.ok(200,"返回全部url",list);
    }
        @RequestMapping("all_author")
        public Result find_all_author(){
        List<Authortag> listorder=authortagService.select_all_author();
        return Result.ok(200,"查询成功",listorder);
        }
}
