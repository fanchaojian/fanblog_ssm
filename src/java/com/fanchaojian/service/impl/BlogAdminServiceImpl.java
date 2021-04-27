package com.fanchaojian.service.impl;

import com.fanchaojian.dao.BlogAdminMapper;
import com.fanchaojian.pojo.BlogAdmin;
import com.fanchaojian.service.IBlogAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanchaojian
 * @date 2021-4-21 - 14:45
 */
@Service
public class BlogAdminServiceImpl implements IBlogAdminService {
    @Autowired
    private BlogAdminMapper blogAdminMapper ;

    /*查找管理员信息，默认排序第一条*/
    @Override
    public BlogAdmin findAdmin() {
        return blogAdminMapper.findAdmin();
    }

    @Override
    public int updateBlogAdmin(BlogAdmin blogAdmin) {
        int i = blogAdminMapper.updateBlogAdmin(blogAdmin);
        return i ;
    }

    @Override
    public int updateLoginInfo(Integer adminId, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("adminId",adminId) ;
        map.put("password",password) ;

        int i = blogAdminMapper.updateLoginInfo(map);
        return i ;
    }

    @Override
    public BlogAdmin login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("username",username) ;
        map.put("password",password) ;
        return blogAdminMapper.login(map);
    }
}
