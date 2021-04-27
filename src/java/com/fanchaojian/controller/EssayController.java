package com.fanchaojian.controller;

import com.fanchaojian.pojo.BlogAdmin;
import com.fanchaojian.pojo.Essay;
import com.fanchaojian.service.IEssayService;
import com.fanchaojian.utils.JsonResult;
import com.fanchaojian.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author fanchaojian
 * @date 2021-4-21 - 17:45
 */
@Controller
@RestController
@RequestMapping("essay")
public class EssayController {

    @Autowired
    private IEssayService essayService ;

    /**
     * 添加随笔     ----admin   已测试
     * */
    @PostMapping("baseAdmin/save")
    public JsonResult addEssay(String content){
        Essay essay = new Essay();
        essay.setContent(content);
        essay.setCreateDate(new Date());

        int i = essayService.addEssay(essay);
        return ResultUtils.successExecute(i);
    }


    /**
     * 通过id查找     ----blog  已测试
     * */
    @GetMapping("findById")
    public JsonResult findById(int essayId){
        Essay essay = essayService.findById(essayId);
        return ResultUtils.success(essay) ;
    }

    /*查找所有  ----BlogAdmin   已测试
    * */
    @GetMapping("")
    public JsonResult findAll(){
        return ResultUtils.success(essayService.findAll()) ;
    }

    /*删除essay   ----admin   已测试
    **/
    @PostMapping("baseAdmin/delete")
    public JsonResult deleteEssay(int essayId){
        int i = essayService.deleteEssay(essayId);
        return ResultUtils.successExecute(i) ;
    }
}
