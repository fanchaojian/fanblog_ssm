package com.fanchaojian.controller;

import com.fanchaojian.pojo.Comment;
import com.fanchaojian.service.ICommentService;
import com.fanchaojian.service.IReplyService;
import com.fanchaojian.utils.JsonResult;
import com.fanchaojian.utils.ResultUtils;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fanchaojian
 * @date 2021-4-22 - 15:06
 */
@Controller
@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private ICommentService commentService ;


    /**                         //Admin and  user   已测试
     * 添加评论 or 添加留言 返回
     * @param type 评论类型，文章评论：comment,留言：gurstbook
     * @param articleId 文章的id
     * @param userId    评论用户的id
     * @param content   评论内容
     * @return
     */
    @PostMapping("baseUser/addComment")
    public JsonResult addComment(int articleId,int userId,String content,String type){
        int i = commentService.addComment(articleId, userId, content, type);

        return ResultUtils.successExecute(i) ;
    }


    /**通过文章id查找所有的评论,以及评论回复     ----blog    已测试
     * */
    @GetMapping("")
    public JsonResult findByArticle(int articleId){
        List<Comment> comments = commentService.findByArticle(articleId);
        return ResultUtils.success(comments) ;
    }

    /*查询所有的留言，不查询回复   ----blog    已测试
    * */
    @GetMapping("findGuestbook")
    public JsonResult findAllGuestbook(){
        List<Comment> comments = commentService.findAllGuestbook();
        return ResultUtils.success(comments) ;
    }

    /*通过id查找评论      已测试
    * */
    @GetMapping("{commentId}")
    public JsonResult findById(@PathVariable int commentId){
        Comment comment = commentService.findById(commentId);
        return ResultUtils.success(comment) ;
    }

    /*删除评论以及所有的回复   --admin     已测试
    * */
    @PostMapping("baseAdmin/deleteComment")
    public JsonResult deleteComment(int commentId){
        int i = commentService.deleteComment(commentId);
        return ResultUtils.successExecute(i);
    }

}
