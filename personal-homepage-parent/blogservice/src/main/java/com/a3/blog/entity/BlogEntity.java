package com.a3.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * blog
 * @author 
 */
public class BlogEntity implements Serializable {
    private Integer id;

    private String title;

    private String authorId;

    private String likes;

    private Date createdTime;

    private Date modifiedTime;

    private String modifiedBy;

    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", authorId=").append(authorId);
        sb.append(", likes=").append(likes);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifiedBy=").append(modifiedBy);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}