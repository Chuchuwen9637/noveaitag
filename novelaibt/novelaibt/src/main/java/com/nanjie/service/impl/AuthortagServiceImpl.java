package com.nanjie.service.impl;

import com.nanjie.entity.Authortag;
import com.nanjie.mapper.AuthortagMapper;
import com.nanjie.service.IAuthortagService;
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
 * @since 2022-10-16
 */
@Service
public class AuthortagServiceImpl extends ServiceImpl<AuthortagMapper, Authortag> implements IAuthortagService {
    @Autowired
    AuthortagMapper authortagMapper;
    @Override
    public List<String> select_url_all() {
        return authortagMapper.selectallurl();
    }

    @Override
    public List<Authortag> select_all_author() {
        return authortagMapper.select_all_authtag();
    }
}
