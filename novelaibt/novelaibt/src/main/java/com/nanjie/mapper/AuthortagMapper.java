package com.nanjie.mapper;

import com.nanjie.entity.Authortag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2022-10-16
 */
public interface AuthortagMapper extends BaseMapper<Authortag> {
List<String> selectallurl();
List<Authortag> select_all_authtag();
}
