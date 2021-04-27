package com.fanchaojian.service.impl;

import com.fanchaojian.dao.ReplyMapper;
import com.fanchaojian.pojo.Reply;
import com.fanchaojian.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

/**
 * @author fanchaojian
 * @date 2021-4-23 - 14:05
 */
@Service
public class ReplyServiceImpl implements IReplyService {

    @Autowired
    private ReplyMapper replyMapper ;

    /*添加回复，并返回回复和回复的关联用户信息*/

    @Override
    public int addReply(int articleId, String content, String replyType, int targetId, int commentId, int fromUid, int toUid) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("articleId",articleId) ;
        map.put("content",content) ;
        map.put("createDate",new Date()) ;
        map.put("replyType",replyType) ;
        map.put("targetId",targetId) ;
        map.put("commentId",commentId) ;
        map.put("fromUid",fromUid) ;
        map.put("toUid",toUid) ;

        int i = replyMapper.addReply(map);
        return i ;
    }

    @Override
    public int deleteById(int replyId) {
        int i = replyMapper.deleteById(replyId);
        return i ;
    }

    @Override
    public int deleteByComment(int commentId) {
        int i = replyMapper.deleteByComment(commentId);
        return i ;
    }

}
