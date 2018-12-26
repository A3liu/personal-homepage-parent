package com.a3.blog.dao;

import java.util.List;

import com.a3.blog.entity.CommentEntity;
import org.apache.ibatis.annotations.Param;

public interface CommentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentEntity record);

    int insertSelective(CommentEntity record);

    CommentEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentEntity record);

    int updateByPrimaryKey(CommentEntity record);
}