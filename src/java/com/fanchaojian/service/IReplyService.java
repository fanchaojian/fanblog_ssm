package com.fanchaojian.service;

import com.fanchaojian.pojo.Reply;

/**
 * @author fanchaojian
 * @date 2021-4-23 - 13:59
 */
public interface IReplyService {
    //添加回复，返回插入的条数
    int addReply(int articleId,String content,String replyType,int targetId,int commentId,int fromUid,int toUid) ;

    //通过replyId删除回复
    int deleteById(int replyId) ;

    //通过commentId删除所有回复
    int deleteByComment(int commentId) ;
}
