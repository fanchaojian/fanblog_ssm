package com.fanchaojian.controller;

import com.alibaba.fastjson.JSONReader;
import com.fanchaojian.pojo.Article;
import com.fanchaojian.service.IArticleService;
import com.fanchaojian.utils.JsonResult;
import com.fanchaojian.utils.ResultUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 16:56
 */
@Controller
@RestController
@RequestMapping("article")
public class ArticleController {
    //注入service articleService
    @Autowired
    private IArticleService articleService ;

    //新增文章,并且可根据传递的标签名称自动查找或添加标签  ---admin  已测试
    @PostMapping("baseAdmin/save")
    public JsonResult saveArticle(String labelName,String title,String author,String iconUrl,String intro,String content,String reprintSite){
        /*封装article*/
        Article article = new Article(title,author,iconUrl,intro,content,new Date(),reprintSite,0,0,0);

        int i = articleService.saveArticle(article, labelName);

        return ResultUtils.successExecute(i) ;
     }

    //通过id删除文章  ----admin 已测试
    @PostMapping("baseAdmin/delete")
    public JsonResult deleteArticle(int articleId){
        int i = articleService.deleteArticle(articleId);
        return ResultUtils.success(i) ;
    }

    //通过id查找    ----blog  已测试
    @GetMapping("findById")
    public JsonResult findById(int articleId,HttpServletRequest request){
        Article article = articleService.findById(articleId,request);

        return ResultUtils.success(article) ;
    }

    /*查询所有文章，并进行分页 */  //---blog 已测试
    @GetMapping("")
    public JsonResult findAll(int pageSize, int pageCount){
        List<Article> articles = articleService.findAll(pageSize, pageCount);
        return ResultUtils.success(articles) ;
    }

    /**
     * 修改文章基本信息     //----admin  已测试
     * 参数：title , author ,content , iconUrl ,intro, articleId
     * @return
     * 必填字段：articleId
     */
    @PostMapping("baseAdmin/update")
    public JsonResult updateArticle(String title , String author ,String content , String iconUrl ,String intro, int articleId,String labelName){

        int i = articleService.updateArticle(title,author,content,iconUrl ,intro, articleId,labelName);
        return ResultUtils.success(i) ;
    }

    //关键字搜索    ----blog   已测试
    @GetMapping("findByKeywords")
    public JsonResult findByKeywords(String keywords){
        List<Article> articles = articleService.findByKeywords(keywords);
        return ResultUtils.success(articles) ;
    }

    //通过标签名称查找，并按照时间降序排序      ----blog    已测试
    @GetMapping("findByLabel")
    public JsonResult findArticlesByLable(String labelName){
        List<Article> articles = articleService.getArticleByLabel(labelName);
        return ResultUtils.success(articles) ;
    }

    //通过年份分组查找      ----bolg    已测试
    @GetMapping("byYear")
    public JsonResult findArticleByYear(){
        Map<String, List<Article>> articleByYear = articleService.getArticleByYear();
        return ResultUtils.success(articleByYear) ;
    }

    /**
     * 修改文章动态字段：如评论数，浏览数，获赞数    //----blog  已测试
     * @param articleId
     * @param type
     *      type:comment:评论数
     *      read：浏览量
     *      like：获赞数
     */
    @PostMapping("dynamicInfo")
    public JsonResult doDynamicInfo(int articleId,String type){
        System.out.println("执行点赞，浏览，评论逻辑"+articleId+"******"+type) ;
        articleService.doDynamicInfo(articleId,type);
        return ResultUtils.success() ;
    }

}
