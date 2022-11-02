package com.nanjie.controller;


import com.nanjie.common.Result;
import com.nanjie.mapper.DashangMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2022-10-23
 */
@RestController
@RequestMapping("/dashang")
public class DashangController {
    @Autowired
    private DashangMapper dashangMapper;
    @RequestMapping("all_dasahng")
    public Result selectdasahnga(){
        return Result.ok(200,"ok",dashangMapper.selectList(null));
    }
}
