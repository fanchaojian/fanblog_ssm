package com.fanchaojian.service;

import com.fanchaojian.pojo.User;

import java.util.List;

/**
 * @author fanchaojian
 * @date 2021-4-22 - 10:47
 */
public interface IVisitorUserService {
    /*登录*/
    User login(String name,String email) ;

    /*添加用户*/
    User addUser(User user) ;

    /*修改用户基本信息*/
    User modifyInfo(int userID,String email,String icon,String gender,int emailReply) ;

    /*通过id查找用户*/
    User findById(int userId) ;

    /*通过openId查找用户*/
    User findByOpenId(String openId) ;

    /*通过unionId查找用户*/
    User findByUnionId(String unionId);

    /*查找所有用户*/
    List<User> getAll() ;

    /*删除用户，其实没有真正删除用户，只是将“是否启用字段设置为0”，但是以往的评论依然可见*/
    int deleteUser(int uid) ;

}
