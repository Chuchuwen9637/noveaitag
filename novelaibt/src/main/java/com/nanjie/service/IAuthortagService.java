package com.nanjie.service;

import com.nanjie.entity.Authortag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2022-10-16
 */
public interface IAuthortagService extends IService<Authortag> {
List<String> select_url_all();
//倒叙查询
List<Authortag> select_all_author();
}
