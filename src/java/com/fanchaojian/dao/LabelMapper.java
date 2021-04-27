package com.fanchaojian.dao;

import com.fanchaojian.pojo.Label;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 15:36
 */
@Repository
public interface LabelMapper {
    /*通过标签名称查找标签*/
    Label findByName(String labelName) ;

    /*通过id查找标签*/
    Label findById(int labelId) ;

    /*查找所有标签*/
    List<Label> findAll() ;

    /*修改标签信息*/
    int updateLabel(Label label) ;

    /*添加标签*/
    int addLabel(Label label) ;

}
