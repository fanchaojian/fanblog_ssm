package com.fanchaojian.dao;

import com.fanchaojian.pojo.Article;
import com.fanchaojian.pojo.Label;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 15:34
 */
@Repository
public interface ArticleMapper {
    /*增加*/
    int saveArticle(Map<String,Object> map) ;

    /*删除*/
    int deleteArticle(int articleId) ;

    /*通过id查找*/
    Article findById(Integer articleId) ;

    /*关键字搜索*/
    List<Article> findByKeywords(String keywords) ;

    /*查找所有，支持分页*/
    List<Article> findAll(Map<String,Integer> params) ;

    /*修改*/
    int updateArticle(Map<String,Object> map) ;

    /*通过标签名称查找所有的文章*/
    List<Article>  getArticleByLabel(String labelName) ;

    /*通过年份分组查找文章*/
    List<Article> getArticleByYear() ;

    /*增加评论*/
    void doComment (int articleId) ;

    /*增减阅读数*/
    void doRead (int articleId) ;

    /*添加获赞数*/
    void doLike (int articleId) ;
}
