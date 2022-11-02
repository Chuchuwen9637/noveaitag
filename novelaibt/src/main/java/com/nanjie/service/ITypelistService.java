package com.nanjie.service;

import com.nanjie.entity.Typelist;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nanjie.entity.vo.typeList_vo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2022-10-14
 */
public interface ITypelistService extends IService<Typelist> {
    //查询id下的类型
    List<Typelist> select_byId_typelist(int typeid);
    List<Typelist> select_byname__typelist(String name);
    //搜索并分页
    int select_typelist_count(String name);
    //模糊搜索 并分页
    List<Typelist> select_litem(typeList_vo vo);
}
