package com.nanjie.mapper;

import com.nanjie.entity.Typelist;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nanjie.entity.vo.typeList_vo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2022-10-14
 */
public interface TypelistMapper extends BaseMapper<Typelist> {
    //查询id下的类型
    List<Typelist> select_byId_typelist(int typeid);

    //查询固定name的
    List<Typelist> select_byName_typelist(String typename);

    //查询分页有多少页,且模糊查询
    Integer   select_typeList_count(String chinesename);
    //模糊搜索加分页
    List<Typelist> select_limit_typelist(typeList_vo vo);
}