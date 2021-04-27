package com.fanchaojian.service.impl;

import com.fanchaojian.dao.CommentMapper;
import com.fanchaojian.pojo.Comment;
import com.fanchaojian.pojo.User;
import com.fanchaojian.service.ICommentService;
import com.fanchaojian.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fanchaojian
 * @date 2021-4-22 - 15:04
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper ;

    @Autowired
    private IReplyService replyService ;

    @Override
    public int addComment(int articleId,int userId,String content,String type) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("articleId",articleId) ;
        map.put("userId",userId) ;
        map.put("content",content) ;
        map.put("type",type);
        map.put("createDate",new Date()) ;

        int i = commentMapper.addComment(map);
        //commentMapper.find

        return i ;
    }

    /*查找文章的评论以及回复*/
    @Override
    public List<Comment> findByArticle(int articleId) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("articleId",articleId) ;
        return commentMapper.findCommentOrGuestbook(map);
    }

    /*查找所有的留言*/
    @Override
    public List<Comment> findAllGuestbook() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type","guestbook") ;
        return commentMapper.findCommentOrGuestbook(map);
    }

    @Override
    public Comment findById(int commentID) {
        return commentMapper.findById(commentID) ;
    }

    @Override
    public int deleteComment(int commentId) {
        //先删除所有的回复
        int i1 = replyService.deleteByComment(commentId);
        System.out.println("删除回复的数量："+i1) ; 
        //在删除评论
        int i = commentMapper.deleteComment(commentId);

        return i ;
    }
}
