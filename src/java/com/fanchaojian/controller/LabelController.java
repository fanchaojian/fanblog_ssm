package com.fanchaojian.controller;

import com.fanchaojian.pojo.Article;
import com.fanchaojian.pojo.Label;
import com.fanchaojian.service.ILabelService;
import com.fanchaojian.utils.JsonResult;
import com.fanchaojian.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fanchaojian
 * @date 2021-4-20 - 14:55
 */
@Controller
@RestController
@RequestMapping("label")
public class LabelController {
    @Autowired
    private ILabelService labelService ;

    /**
     * 通过标签名称查找或插入标签
     * @param labelName
     * @return
     */
    @GetMapping("baseAdmin/findOrInsert")
    public JsonResult findOrInsert(String labelName){
        int insertId = labelService.findOrInsert(labelName);
        return ResultUtils.success(insertId) ;
    }

    /**
     * 添加标签，并返回新添加标签的id     ----已测试
     * @param labelName
     * @param remark
     * @return
     */
    @PostMapping("baseAdmin/save")
    public JsonResult addLabel(String labelName,String remark){
        Label label = new Label(labelName, remark);
        int articleId = labelService.addLabel(label);
        return ResultUtils.success(articleId) ;
    }

    /**
     * 修改标签     ----已测试
     * 必须传递的参数：String labelName,String remark,int labelId
     * @return
     */
    @PostMapping("baseAdmin/update")
    public JsonResult updateLabel(Label label){
        int i = labelService.updateLabel(label);
        return ResultUtils.successExecute(i) ;
    }

    /**
     * 通过标签名称查找标签       ----已测试
     * @param labelName
     * @return
     */
    @GetMapping("findByName")
    public JsonResult findByName(String labelName){
        Label label = labelService.findByName(labelName);
        return ResultUtils.success(label) ;
    }

    //查找所有标签   ----blog   已测试
    @GetMapping("")
    public JsonResult findAll(){
        return ResultUtils.success(labelService.findAll()) ;
    }

}
