package com.fanchaojian.service.impl;

import com.fanchaojian.dao.ArticleMapper;
import com.fanchaojian.pojo.Article;
import com.fanchaojian.service.IArticleService;
import com.fanchaojian.service.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 16:47
 */
@Service
public class ArticleServiceImpl implements IArticleService {
    //注入dao mapper  ArticleMapper
    @Autowired
    private ArticleMapper articleMapper  ;

    //注入labelService
    @Autowired
    private ILabelService labelService ;

    //添加新的文章
    @Override
    public int saveArticle(Article article,String labelName) {
        //先同过名称查找标签，如果没有标签，则先插入标签，然后再保存文章
        int labelId = labelService.findOrInsert(labelName);
        //#{author}, #{commentCount}, #{content}, #{createDate}, #{iconUrl}, #{intro}, #{likeCount}, #{readCount}, #{reprintSite}, #{title}, #{labelid},#{label.labelId}
        Map<String, Object> map = new HashMap<>();
        map.put("title",article.getTitle()) ;
        map.put("author",article.getAuthor()) ;
        map.put("content",article.getContent()) ;
        map.put("iconUrl",article.getIconUrl()) ;
        map.put("intro",article.getIntro()) ;
        map.put("reprintSite",article.getReprintSite()) ;
        map.put("createDate",article.getCreateDate()) ;
        map.put("commentCount",article.getCommentCount()) ;
        map.put("likeCount",article.getLikeCount()) ;
        map.put("readCount",article.getReadCount()) ;
        map.put("labelId",labelId) ;

        return articleMapper.saveArticle(map);
    }

    //通过id删除文章
    @Override
    public int deleteArticle(int articleId) {
        int i = articleMapper.deleteArticle(articleId);
        return i;
    }

    //通过id查找，并新增浏览量，同一个session下不增加浏览量
    @Override
    public Article findById(Integer articleId,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Article article = articleMapper.findById(articleId);

        if(article != null){
            Integer arId  = (Integer) session.getAttribute("article");
            if(arId == null || arId != articleId){
                //增加文章的访问量
                articleMapper.doRead(articleId);
                session.setAttribute("article",articleId);
            }
        }

        return article ;
    }


    //通过关键字搜索，支持分页
    @Override
    public List<Article> findByKeywords(String keywords) {

        return articleMapper.findByKeywords("%"+keywords+"%");
    }

    //查找文章，并分页
    @Override
    public List<Article> findAll(int pageSize,int pageCount) {
        int startIndex = (pageSize-1)*pageCount ;
        HashMap<String, Integer> params = new HashMap<>();
        params.put("startIndex",startIndex) ;
        params.put("pageCount",pageCount) ;

        return articleMapper.findAll(params) ;
    }


    //修改
    @Override
    public int updateArticle(String title , String author ,String content , String iconUrl ,String intro, int articleId,String labelName) {
        int labelId = labelService.findOrInsert(labelName);

        Map<String, Object> map = new HashMap<>();
        map.put("title",title) ;
        map.put("author",author) ;
        map.put("content",content) ;
        map.put("iconUrl",iconUrl) ;
        map.put("intro",intro) ;
        map.put("articleId",articleId) ;
        map.put("labelId",labelId) ;

        int i = articleMapper.updateArticle(map);
        return i ;
    }

    //通过标签名查找
    @Override
    public List<Article> getArticleByLabel(String labelName) {
        return articleMapper.getArticleByLabel(labelName);
    }

    //通过年份分组查找
    @Override
    public Map<String, List<Article>> getArticleByYear() {
        List<Article> list = articleMapper.getArticleByYear();

        Map<String,List<Article>> articleMap = new LinkedHashMap<String,List<Article>>() ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        //遍历数据，根据createDate 判断再 放入map中
        for(Article article : list){
            if(article.getCreateDate() != null ){
                String formatDate = sdf.format(article.getCreateDate());
                String myDate = formatDate.substring(0,4) ;

                //判断map中是否有同名的key
                boolean hasKey = articleMap.containsKey(myDate);
                if(hasKey){
                    List<Article> articles = articleMap.get(myDate);
                    articles.add(article) ;
                }else{
                    ArrayList<Article> articles = new ArrayList<>();
                    articles.add(article) ;
                    articleMap.put(myDate,articles)  ;
                }
            }
        }

        return articleMap;
    }


    //评论数，阅读数，点赞数  的增加
    @Override
    public void doDynamicInfo(int articleId, String type) {
        Article article = articleMapper.findById(articleId);
        if(article == null){
            throw new RuntimeException("没有找到id为["+articleId+"]的记录，更新动态字段失败") ;
        }
        if("comment".equals(type)){
            articleMapper.doComment(articleId);
            System.out.println("执行评论") ;
        }else if("read".equals(type)){
            articleMapper.doRead(articleId);
            System.out.println("执行浏览") ;
        }else if("like".equals(type)){
            System.out.println("执行点赞") ;
            articleMapper.doLike(articleId);
        }else {
            throw new RuntimeException("没有可选的类型["+type+"],可供选择类型comment，read，like") ;
        }
    }

}
