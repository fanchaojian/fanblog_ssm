package com.fanchaojian.service.impl;

import com.fanchaojian.dao.LabelMapper;
import com.fanchaojian.pojo.Label;
import com.fanchaojian.service.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author fanchaojian
 * @date 2021-4-20 - 15:15
 */
@Service
public class ILabelServiceImpl implements ILabelService {
    @Autowired
    private LabelMapper labelMapper ;

    /**插入或查找标签
     * @param labelName
     * @return
     */
    @Override
    public int findOrInsert(String labelName) {
        //查找标签，没有数据就插入标签
        Label findLabel = labelMapper.findByName(labelName);
        if(findLabel == null){
            Label label = new Label();
            label.setLabelName(labelName);

            int labelId = addLabel(label);

            return labelId ;
        }

        return findLabel.getLabelId();
    }

    /**
     * 添加新的标签
     * @param label
     * @return
     */
    @Override
    public int addLabel(Label label) {
        //先查找数据库中的同名标签
        Label byName = findByName(label.getLabelName());
        if(byName == null){
            label.setCreateDate(new Date());
            label.setRemark("");
            label.setArticleCount(0);
            int i = labelMapper.addLabel(label);
            if(i == 1){
                return label.getLabelId() ;
            }else{
                throw new RuntimeException("添加标签失败，请重试")  ;
            }
        }else{
            throw new RuntimeException("已存在同名标签") ;
        }
    }

    /**
     * 通过标签名称查找标签
     * @param labelName
     * @return
     */
    @Override
    public Label findByName(String labelName) {
        return labelMapper.findByName(labelName);
    }

    @Override
    public Label findById(int labelId) {
        return labelMapper.findById(labelId);
    }

    /**
     * 修改标签
     * @param label
     */
    @Override
    public int updateLabel(Label label) {
        int i = labelMapper.updateLabel(label);
        return i ;
    }

    /**
     * 查找所有标签，并且一并关联查询标签下的文章总数
     * @return
     */
    @Override
    public List<Label> findAll() {
        return labelMapper.findAll();
    }
}
