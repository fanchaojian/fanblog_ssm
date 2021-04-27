package com.fanchaojian.controller;

import com.fanchaojian.pojo.Comment;
import com.fanchaojian.pojo.Reply;
import com.fanchaojian.pojo.User;
import com.fanchaojian.service.IReplyService;
import com.fanchaojian.utils.JsonResult;
import com.fanchaojian.utils.ResultUtils;
import com.mysql.jdbc.util.ResultSetUtil;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanchaojian
 * @date 2021-4-23 - 14:23
 */
@Controller
@RestController
@RequestMapping("reply")
public class ReplyController {
    @Autowired
    private IReplyService replyService ;

    //添加回复     已测试
    @PostMapping("baseUser/add")
    public JsonResult addReply(int articleId,String content,String replyType,int targetId,int commentId,int fromUid,int toUid){
        int i = replyService.addReply(articleId,content,replyType,targetId,commentId,fromUid,toUid);

        return ResultUtils.successExecute(i) ;
    }

    //通过replyId删除回复    已测试
    @PostMapping("baseAdmin/deleteById")
    public JsonResult deleteById(int replyId){
        int i = replyService.deleteById(replyId);
        return ResultUtils.success(i) ;

    }


}
