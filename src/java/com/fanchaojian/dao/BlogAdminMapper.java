package com.fanchaojian.dao;

import com.fanchaojian.pojo.BlogAdmin;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 15:35
 */
@Repository
public interface BlogAdminMapper {
    /*查找,默认为第一条数据，preOrder：用于排序*/
    BlogAdmin findAdmin() ;

    /*修改基本信息*/
    int updateBlogAdmin(BlogAdmin blogAdmin) ;

    /*修改密码*/
    int updateLoginInfo(Map<String,Object> map) ;

    /*登录逻辑，通过用户名和密码查找管理员，并加载关联站点信息*/
    BlogAdmin login(Map<String,Object> map) ;
}
