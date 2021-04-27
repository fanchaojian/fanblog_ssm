package com.fanchaojian.service;

import com.fanchaojian.pojo.Comment;

import java.util.List;

/**
 * @author fanchaojian
 * @date 2021-4-22 - 15:02
 */
public interface ICommentService {
    /*添加评论*/
    int addComment(int articleId,int userId,String content,String type) ;


    /*通过文章id查找所有的评论,以及评论回复*/
    List<Comment> findByArticle(int articleId) ;

    /*查询所有的留言*/
    List<Comment> findAllGuestbook() ;

    /*通过id查找评论*/
    Comment findById(int commentID) ;

    /*删除评论*/
    int deleteComment(int commentId) ;
}
