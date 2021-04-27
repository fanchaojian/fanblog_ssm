package com.fanchaojian.controller;

import com.fanchaojian.pojo.BlogAdmin;
import com.fanchaojian.service.IBlogAdminService;
import com.fanchaojian.utils.JsonResult;
import com.fanchaojian.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanchaojian
 * @date 2021-4-21 - 14:53
 */
@Controller
@RestController
@RequestMapping("blogAdmin")
public class BlogAdminController {
    @Autowired
    private IBlogAdminService blogAdminService ;

    /**
     * 查找管理员    ----blog    已测试
     * @return
     */
    @GetMapping("")
    public JsonResult findAdmin(){
        BlogAdmin admin = blogAdminService.findAdmin();
        System.out.println("管理员："+admin.toString()) ;
        return ResultUtils.success(admin) ;
    }

    /**
     * 修改基本信息      //----admin  已测试
     * @param blogAdmin
     *      adminId:
     *      "name":
    "job":
    "email":
    "place":
    "hobby":
    "motto":
    "introUrl":
    "gender":
    "iconUrl":
    "qqQrcode":
    "wechatQrcode":
    "weboQrcode":
    "gghQrcode":
    "githubUrl":
     * @return
     */
    @PostMapping("baseAdmin/updateBaseInfo")
    public JsonResult updateBlogAdmin(BlogAdmin blogAdmin){
        int i = blogAdminService.updateBlogAdmin(blogAdmin);
        return ResultUtils.successExecute(i) ;
    }

    /*修改密码*/    //----admin     已测试
    @PostMapping("baseAdmin/updateLoginInfo")
    public JsonResult updateLoginInfo(Integer adminId,String password){
        int i = blogAdminService.updateLoginInfo(adminId, password.trim());
        return ResultUtils.successExecute(i);
    }

    /*登录逻辑*/   //---all     已测试
    @PostMapping("login")
    public JsonResult login(String username,String password){
        BlogAdmin admin = blogAdminService.login(username, password);
        if(admin == null){
            return ResultUtils.error(101,"登录失败，检查用户名或密码") ;
        }

        return ResultUtils.success(admin) ;
    }



}
