package com.social.chenl.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author : lance.chen
 *
 * time   : 2018/04/15
 * desc   : BaseMapper
 * version: 1.0
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
