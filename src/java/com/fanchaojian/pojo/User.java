package com.fanchaojian.pojo;

import org.apache.ibatis.mapping.FetchType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 15:38
 */
public class User {
    private Integer userId ;
    private String registerMethod ; /*注册方式：localhost，qq,wechat。通过不同的登录方式获取不同的用户信息*/
    private String name ;       /*登录用户名*/
    private String email ;
    private String openId ;   /*第三方QQ登录获取到的唯一标识符*/
    private String unionId ;  /*第三方wechat登录获取到的用户唯一标识*/
    private String icon ;        /*默认会自动分配*/
    private String gender ;
    private Integer emailReply ;  /*是否进行邮件回复*/
    private Integer isInuse ;     /*是否启用，1：启用。0：没有启用。当为0时可以看成是次账户已经被删除。*/

    /*mappedBy:多方的关联属性名，cascade,允许关联方关联操作此对象，fetch:立即查询此关联对象，并放入内存，保证有session进行事务的控制。*/
    private List<Comment> comments ;

    /*来源*/
    private List<Reply> sourceReply ;

    /*目标*/
    private List<Reply> targetReply ;

    public User() {
    }

    public User(Integer userId, String registerMethod, String name, String email, String openId, String unionId, String icon, String gender, Integer emailReply, Integer isInuse, List<Comment> comments, List<Reply> sourceReply, List<Reply> targetReply) {
        this.userId = userId;
        this.registerMethod = registerMethod;
        this.name = name;
        this.email = email;
        this.openId = openId;
        this.unionId = unionId;
        this.icon = icon;
        this.gender = gender;
        this.emailReply = emailReply;
        this.isInuse = isInuse;
        this.comments = comments;
        this.sourceReply = sourceReply;
        this.targetReply = targetReply;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRegisterMethod() {
        return registerMethod;
    }

    public void setRegisterMethod(String registerMethod) {
        this.registerMethod = registerMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getEmailReply() {
        return emailReply;
    }

    public void setEmailReply(Integer emailReply) {
        this.emailReply = emailReply;
    }

    public Integer getIsInuse() {
        return isInuse;
    }

    public void setIsInuse(Integer isInuse) {
        this.isInuse = isInuse;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Reply> getSourceReply() {
        return sourceReply;
    }

    public void setSourceReply(List<Reply> sourceReply) {
        this.sourceReply = sourceReply;
    }

    public List<Reply> getTargetReply() {
        return targetReply;
    }

    public void setTargetReply(List<Reply> targetReply) {
        this.targetReply = targetReply;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", registerMethod='" + registerMethod + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", openId='" + openId + '\'' +
                ", unionId='" + unionId + '\'' +
                ", icon='" + icon + '\'' +
                ", gender='" + gender + '\'' +
                ", emailReply=" + emailReply +
                ", isInuse=" + isInuse +
                ", comments=" + comments +
                ", sourceReply=" + sourceReply +
                ", targetReply=" + targetReply +
                '}';
    }
}

