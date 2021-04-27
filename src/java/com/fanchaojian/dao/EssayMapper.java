package com.fanchaojian.dao;

import com.fanchaojian.pojo.Essay;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 15:35
 */
@Repository
public interface EssayMapper {
    /*添加随笔*/
    int addEssay(Essay essay) ;

    /*通过id查找*/
    Essay findById(int id) ;

    /*查找所有*/
    List<Essay> findAll() ;

    /*删除essay*/
    int deleteEssay(int essayId) ;
}
