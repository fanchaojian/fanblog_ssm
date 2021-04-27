package com.fanchaojian.pojo;

import org.apache.ibatis.mapping.FetchType;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 15:37
 */
public class Comment {
    private Integer id ;
    private String type ;           /*评论类型，用于区分是留言还是评论。comment,guestbook*/
    private Integer articleId ;     /*文章id：为了与博客文章减少关联，这儿就不用外键了，手动添加。当评论为留言的时候，此项为默认值0*/
    private String content ;        /*评论内容*/
    private Date createDate ;       /*创建时间，记录生成时生成*/

    private Integer replyCount ;    //回复的数量，用于接收SQL列，在表中没有体现

    /*评论用户，评论与用户是多对一的关系，外键：userId*/
    private User user ;  /*评论用户*/

    /*评论下的回复，一对多关系。*/
    private List<Reply> replys ;

    public Comment() {
    }

    public Comment(Integer id, String type, Integer articleId, String content, Date createDate, User user, List<Reply> replys) {
        this.id = id;
        this.type = type;
        this.articleId = articleId;
        this.content = content;
        this.createDate = createDate;
        this.user = user;
        this.replys = replys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Reply> getReplys() {
        return replys;
    }

    public void setReplys(List<Reply> replys) {
        this.replys = replys;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", articleId=" + articleId +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", user=" + user +
                ", replys=" + replys +
                '}';
    }
}
