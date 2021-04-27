package com.fanchaojian.service;

import com.fanchaojian.pojo.Label;

import java.util.List;

/**
 * @author fanchaojian
 * @date 2021-4-20 - 15:09
 */
public interface ILabelService {
    //通过标签名称查找或插入标签
    int findOrInsert(String labelName) ;


    /*通过标签名称查找标签*/
    Label findByName(String labelName) ;

    /*通过id查找标签*/
    Label findById(int labelId) ;

    /*查找所有标签*/
    List<Label> findAll() ;

    /*修改标签信息*/
    int updateLabel(Label label) ;

    /*添加标签,返回新添加的标签id*/
    int addLabel(Label label) ;
}
