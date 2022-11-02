package com.nanjie.service.impl;

import com.nanjie.entity.Typelist;
import com.nanjie.entity.vo.typeList_vo;
import com.nanjie.mapper.TypelistMapper;
import com.nanjie.service.ITypelistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2022-10-14
 */
@Service
public class TypelistServiceImpl extends ServiceImpl<TypelistMapper, Typelist> implements ITypelistService {
    @Autowired
    private  TypelistMapper typelist;
    @Override
    public List<Typelist> select_byId_typelist(int typeid) {
        return typelist.select_byId_typelist(typeid);
    }

    @Override
    public List<Typelist> select_byname__typelist( String name) {
        return typelist.select_byName_typelist(name);
    }



    //查询有多少页
    @Override
    public int select_typelist_count(String name) {
        System.out.println("一共"+name);
        return typelist.select_typeList_count(name);
    }

    @Override
    public List<Typelist> select_litem(typeList_vo vo) {
        return  typelist.select_limit_typelist(vo);
    }
}
