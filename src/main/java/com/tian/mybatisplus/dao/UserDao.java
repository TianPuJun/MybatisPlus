package com.tian.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tian.mybatisplus.bean.User;
import org.springframework.stereotype.Repository;

/**
 * dao
 *
 * @author cui
 * @create 2018-09-12 11:34
 **/
@Repository
public interface UserDao extends BaseMapper<User> {
}
