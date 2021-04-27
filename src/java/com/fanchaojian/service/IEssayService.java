package com.fanchaojian.service;

import com.fanchaojian.pojo.Essay;

import java.util.List;

/**
 * @author fanchaojian
 * @date 2021-4-21 - 17:32
 */
public interface IEssayService {
    /*添加随笔*/
    int addEssay(Essay essay) ;

    /*通过id查找*/
    Essay findById(int id) ;

    /*查找所有*/
    List<Essay> findAll() ;

    /*删除essay*/
    int deleteEssay(int essayId) ;
}
