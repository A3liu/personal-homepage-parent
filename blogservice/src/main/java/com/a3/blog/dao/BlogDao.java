package com.a3.blog.dao;


import java.util.List;

import com.a3.blog.entity.BlogEntity;

public interface BlogDao {

    int deleteByPrimaryKey(Integer id);

    int insert(BlogEntity record);

    int insertSelective(BlogEntity record);

    BlogEntity selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(BlogEntity record);


    int updateByPrimaryKey(BlogEntity record);
}