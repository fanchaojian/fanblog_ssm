package com.fanchaojian.dao;

import com.fanchaojian.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author fanchaojian
 * @date 2021-4-22 - 10:28
 */
@Repository
public interface VisitorUserMapper {
    /*登录*/
    User login(Map<String,String> map) ;

    /*添加用户*/
    int addUser(User user) ;

    /*通过邮箱查找用户*/
    User findByEmail(String email) ;

    /*通过name查找用户*/
    User findByName(String name) ;

    /*通过openId查找用户信息，QQ接入用户*/
    User findByOpendId(String opendId) ;

    /*通过unionId查找用户用户信息，wechat接入用户*/
    User findByUnionId(String unionId) ;

    /*通过id查找用户*/
    User findById(int userId) ;

    /*查找所有用户*/
    List<User> getAll() ;

    /*删除用户，其实没有真正删除用户，只是将“是否启用字段设置为0”，但是以往的评论依然可见(逻辑删除)*/
    int deleteUser(int userId) ;

}
