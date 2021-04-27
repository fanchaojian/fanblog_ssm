package com.fanchaojian.service.impl;

import com.fanchaojian.dao.VisitorUserMapper;
import com.fanchaojian.pojo.User;
import com.fanchaojian.service.IVisitorUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fanchaojian
 * @date 2021-4-22 - 10:47
 */
@Service
public class IVisitorUserServiceImpl implements IVisitorUserService {

    @Autowired
    private VisitorUserMapper visitorUserMapper ;

    @Override
    public User login(String name, String email) {
        Map<String, String> map = new HashMap<>();
        map.put("name",name) ;
        map.put("email",email) ;
        map.put("registerMethod","localhost") ;
        return visitorUserMapper.login(map);
    }

    @Override
    public User addUser(User user) {
        if(user.getRegisterMethod() == null){
            throw new RuntimeException("请指定注册方式：registerMethod") ;
        }else if(user.getRegisterMethod().equals("localhost")){
            //判断数据库中是否已经存在相同name或email的用户
            User userByName = visitorUserMapper.findByName(user.getName());
            if(userByName != null){
                throw new RuntimeException("已经存在昵称为["+user.getName()+"]的账户。") ;
            }
            User userByEmail = visitorUserMapper.findByEmail(user.getEmail());
            if(userByEmail != null){
                throw new RuntimeException("此邮箱["+user.getEmail()+"]已经注册，请登录。") ;
            }

            user.setOpenId("");
            user.setUnionId("");
            user.setIsInuse(1);
            visitorUserMapper.addUser(user);
            return user ;
        }else if(user.getRegisterMethod().equals("qq")){
            if(user.getOpenId() != null && user.getOpenId().trim().length() != 0){
                //先查找数据库中是否已经存在此qq登录的账户
                User userByOpendId = visitorUserMapper.findByOpendId(user.getOpenId());
                if(userByOpendId != null){
                    return userByOpendId ;
                }else{
                    user.setUnionId("");
                    user.setEmailReply(0);
                    user.setEmail("");
                    user.setIsInuse(1);
                    visitorUserMapper.addUser(user);
                    return user ;
                }
            }else{
                throw new RuntimeException("请指定openId。") ;
            }

        }else if(user.getRegisterMethod().equals("wechat")){
            if(user.getUnionId() != null && user.getUnionId().trim().length() != 0){
                //先查找数据库中是否已经存在此wechat的账户
                User userByUnionId = visitorUserMapper.findByUnionId(user.getUnionId());
                if(userByUnionId != null){
                    return userByUnionId ;
                }else{
                    user.setOpenId("");
                    user.setEmailReply(0);
                    user.setEmail("");
                    user.setIsInuse(1);
                    visitorUserMapper.addUser(user);
                    return user ;
                }
            }else{
                throw new RuntimeException("请指定unionId。") ;
            }

        }else{
            throw new RuntimeException("请指定注册方式：localhost、qq、wechat") ;
        }
    }

    @Override
    public User modifyInfo(int userID, String email, String icon, String gender, int emailReply) {
        return null;
    }

    @Override
    public User findById(int userId) {
        return visitorUserMapper.findById(userId);
    }

    @Override
    public User findByOpenId(String openId) {
        return visitorUserMapper.findByOpendId(openId);
    }

    @Override
    public User findByUnionId(String unionId) {
        return visitorUserMapper.findByUnionId(unionId);
    }

    @Override
    public List<User> getAll() {
        return visitorUserMapper.getAll();
    }

    @Override
    public int deleteUser(int userId) {
        int i = visitorUserMapper.deleteUser(userId);
        return i ;
    }

}
