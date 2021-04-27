package com.fanchaojian.service;

import com.fanchaojian.pojo.Article;
import com.fanchaojian.pojo.Label;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 16:47
 */
public interface IArticleService {

    /*增加*/
    int saveArticle(Article article,String labelName) ;

    /*删除*/
    int deleteArticle(int articleId) ;

    /*通过id查找*/
    Article findById(Integer articleId,HttpServletRequest request) ;

    /*关键字搜索*/
    List<Article> findByKeywords(String keywords) ;

    /*查找所有文章，分页查询*/
    List<Article> findAll(int pageSize,int pageCount) ;

    /*修改*/
    int updateArticle(String title , String author ,String content , String iconUrl ,String intro, int articleId,String labelName) ;

    /*通过标签名称查找所有的文章*/
    List<Article>  getArticleByLabel(String labelName) ;

    /*通过年份分组查找文章*/
    Map<String,List<Article>> getArticleByYear() ;

    /*如评论（comment）、点赞（like）、浏览数量(read)的增加*/
    void doDynamicInfo(int articleId,String type) ;
}
