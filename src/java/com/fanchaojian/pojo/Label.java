package com.fanchaojian.pojo;

import org.apache.ibatis.mapping.FetchType;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 15:38
 */
public class Label {
    private Integer labelId ;
    private String labelName ;      /*标签名称*/
    private Integer articleCount ;   /*文章总数*/
    private Date createDate ;     /*创建时间*/
    private String remark ;         /*备注*/

    //对应的博客文章
    private List<Article> articles ;

    public Label() {
    }

    public Label(String labelName,String remark){
        this.labelName = labelName ;
        this.remark = remark ;
        this.createDate = new Date() ;
    }

    public Label(Integer labelId, String labelName, Integer articleCount, Date createDate, String remark, List<Article> articles) {
        this.labelId = labelId;
        this.labelName = labelName;
        this.articleCount = articleCount;
        this.createDate = createDate;
        this.remark = remark;
        this.articles = articles;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Label{" +
                "labelId=" + labelId +
                ", labelName='" + labelName + '\'' +
                ", articleCount=" + articleCount +
                ", createDate=" + createDate +
                ", remark='" + remark + '\'' +
                ", articles=" + articles +
                '}';
    }
}
