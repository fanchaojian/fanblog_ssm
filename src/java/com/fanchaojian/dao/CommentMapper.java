package com.fanchaojian.dao;

import com.fanchaojian.pojo.Comment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 15:35
 */
@Repository
public interface CommentMapper {
    /*添加评论*/
    int addComment(Map<String,Object> map) ;


    /*通过文章id查找所有的评论,以及评论的第一条回复，并统计回复的总数*/
    List<Comment> findCommentOrGuestbook(Map<String,Object> map) ;

    /*通过commentId查找所有的评论，以及评论回复*/
    List<Comment> findByCommit(int commentId) ;

    /*通过id查找评论*/
    Comment findById(int commentId) ;

    /*删除评论*/
    int deleteComment(int commentId) ;
}
