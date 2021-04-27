package com.fanchaojian.controller;

import com.fanchaojian.pojo.User;
import com.fanchaojian.service.IVisitorUserService;
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
 * @date 2021-4-22 - 11:24
 */
@Controller
@RestController
@RequestMapping("user")
public class VisitorUserController {
    @Autowired
    private IVisitorUserService visitorUserService ;

    /*登录*/      //----blog  已测试
    @PostMapping("login")
    public JsonResult login(String name,String email){
        return ResultUtils.success(visitorUserService.login(name,email)) ;
    }

    /*修改用户基本信息*/     //----blogUser    逻辑待确认（需要分不用的登录用户进行修改，email和name对于不用的登录用户来说意义不一样）
    @PostMapping("baseSelf/modifyInfo")
    public JsonResult modifyInfo(int userID, String email, String icon, String gender, int emailReply){
        return ResultUtils.success(visitorUserService.modifyInfo(userID,email,icon,gender,emailReply)) ;
    }

    /*查找所有用户*/      //----admin     已测试
    @GetMapping("baseAdmin/getAll")
    public JsonResult getAll() {
        return ResultUtils.success(visitorUserService.getAll())  ;
    }

    /**
     *注册用户    //----blog        已测试
     * 如果是localhost注册将只进行保存操作，如果是第三方登录将执行保存或查找的操作
     * @param user
     *          registerMethod  localhost，qq,wechat
     *          name        localhost登录注册必填
     *          email       允许修改，localhost登录注册必填
     *          openId      QQ登录方式必填
     *          unionId     微信登录方式必填
     *          icon        允许修改
     *          gender      允许修改
     *          emailReply  允许修改
     * @return
     */
    @PostMapping("addOrFind")
    public JsonResult addOrFind(User user){
        return ResultUtils.success(visitorUserService.addUser(user)) ;
    }

    /*通过id查找用户*/        //----blog     已测试
    @GetMapping("baseSelf/findById")
    public JsonResult findById(int userId) {
        return ResultUtils.success(visitorUserService.findById(userId)) ;
    }


    /**
     * 逻辑删除用户   ---admin 已测试
     * @param userId
     * @return
     */
    @PostMapping("baseUser/delete")
    public JsonResult deleteUser(int userId) {
        int i = visitorUserService.deleteUser(userId);
        return ResultUtils.successExecute(i) ;
    }
}
