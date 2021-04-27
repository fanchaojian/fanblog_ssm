package com.fanchaojian.service.impl;

import com.fanchaojian.dao.EssayMapper;
import com.fanchaojian.pojo.Essay;
import com.fanchaojian.service.IEssayService;
import com.fanchaojian.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fanchaojian
 * @date 2021-4-21 - 17:33
 */
@Service
public class EssayServiceImpl implements IEssayService {
    @Autowired
    private EssayMapper essayMapper ;

    @Override
    public int addEssay(Essay essay) {
        int i = essayMapper.addEssay(essay);
        return i ;
    }

    @Override
    public Essay findById(int essayId) {
        return essayMapper.findById(essayId);
    }

    @Override
    public List<Essay> findAll() {
        return essayMapper.findAll();
    }

    @Override
    public int deleteEssay(int essayId) {
        int i = essayMapper.deleteEssay(essayId);
        return i ;
    }
}
