package com.a3.blog.service;

import com.a3.blog.dao.BlogDao;
import com.a3.blog.entity.BlogEntity;
import com.a3.common.util.ExceptionUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: liuyaosen
 * @Date: 2019/1/2 20:53
 */
@Service
public class BlogService {

    @Autowired
    private BlogDao blogDao;

    public int createBlog(BlogEntity blogEntity){

        if(StringUtils.isAnyEmpty(blogEntity.getAuthorId(),blogEntity.getTitle(),blogEntity.getContent())){
            ExceptionUtil.invalidParam();
        }
        blogEntity.setLikes(0);
        blogEntity.setModifiedBy(blogEntity.getAuthorId());
        blogEntity.setCreatedTime(new Date());
        blogEntity.setModifiedTime(new Date());
        blogDao.insert(blogEntity);
        return blogEntity.getId();
    }

}
