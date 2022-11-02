package com.nanjie.controller;


import com.nanjie.common.Result;
import com.nanjie.entity.Totaltype;
import com.nanjie.mapper.TotaltypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/totaltype")
public class TotaltypeController {

    @Autowired
    private TotaltypeMapper totaltypeMapper;
    @RequestMapping("findalltotaltype")
    public Result findalltotaltype(){
        List<Totaltype> list=totaltypeMapper.selectList(null);
        return   Result.ok(200,"查询成功",list);
    }

}
