package com.fanchaojian.pojo;

import java.util.Date;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 15:37
 */
public class Essay {
    private Integer essayId ;
    private Date createDate ;
    private String content ;

    public Essay() {
    }

    public Essay(Integer essayId, Date createDate, String content) {
        this.essayId = essayId;
        this.createDate = createDate;
        this.content = content;
    }

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Essay{" +
                "essayId=" + essayId +
                ", createDate=" + createDate +
                ", content='" + content + '\'' +
                '}';
    }
}
