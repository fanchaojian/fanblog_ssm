package com.fanchaojian.dao;

import com.fanchaojian.pojo.Reply;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 15:36
 */
@Repository
public interface ReplyMapper {

    //添加回复
    int addReply(Map<String,Object> map) ;

    //通过replyId删除回复
    int deleteById(int replyId) ;

    //通过commentId删除所有回复
    int deleteByComment(int commentId) ;

    //通过replyid查找回复,一并查找关联from_user
    Reply findById(int replyId) ;
}
