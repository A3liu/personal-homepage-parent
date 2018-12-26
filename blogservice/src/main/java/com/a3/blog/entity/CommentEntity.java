package com.a3.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * comment
 * @author 
 */
public class CommentEntity implements Serializable {
    private Integer id;

    private Integer parentCommentId;

    private Integer blogId;

    private String authorId;

    private String authorName;

    private String replyAuthorId;

    private String commentContent;

    private Integer likes;

    private Date createdTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getReplyAuthorId() {
        return replyAuthorId;
    }

    public void setReplyAuthorId(String replyAuthorId) {
        this.replyAuthorId = replyAuthorId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentCommentId=").append(parentCommentId);
        sb.append(", blogId=").append(blogId);
        sb.append(", authorId=").append(authorId);
        sb.append(", authorName=").append(authorName);
        sb.append(", replyAuthorId=").append(replyAuthorId);
        sb.append(", commentContent=").append(commentContent);
        sb.append(", likes=").append(likes);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}