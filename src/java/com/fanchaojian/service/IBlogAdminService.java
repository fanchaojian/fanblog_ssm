package com.fanchaojian.service;

import com.fanchaojian.pojo.BlogAdmin;

/**
 * @author fanchaojian
 * @date 2021-4-21 - 14:44
 */
public interface IBlogAdminService {
    /*查找*/
    BlogAdmin findAdmin() ;

    /*修改*/
    int updateBlogAdmin(BlogAdmin blogAdmin) ;

    /*修改密码*/
    int updateLoginInfo(Integer adminId,String password) ;

    /*登录逻辑，通过用户名和密码查找管理员*/
    BlogAdmin login(String username,String password) ;
}
