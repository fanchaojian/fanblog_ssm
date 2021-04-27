package com.fanchaojian.controller;

import com.fanchaojian.pojo.SiteInfo;
import com.fanchaojian.service.ISiteInfoService;
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
 * @date 2021-4-21 - 16:33
 */
@Controller
@RestController
@RequestMapping("site")
public class SiteInfoController {

    @Autowired
    private ISiteInfoService siteInfoService ;

    /**
     * 站点信息，默认为第一个blogAdmin对应的站点       ----已测试
     * */
    @GetMapping("")
   public JsonResult getSiteInfo(){
       SiteInfo siteInfo = siteInfoService.getSiteInfo();
       return ResultUtils.success(siteInfo);
   }

    /**
     * 修改基本信息   ----已测试
     * */
    @PostMapping("baseAdmin/updateSiteInfo")
    public JsonResult updateSiteInfo(int siteId,String logoImg,String siteBbiUrl,String siteIntroUrl,String siteName,String siteQrcode) {
        SiteInfo site = new SiteInfo();
        site.setSiteId(siteId);
        site.setLogoImg(logoImg);
        site.setSiteBgiUrl(siteBbiUrl);
        site.setSiteIntroUrl(siteIntroUrl);
        site.setSiteName(siteName);
        site.setSiteQrcode(siteQrcode);

        int i = siteInfoService.updateSiteInfo(site);

        return ResultUtils.successExecute(i) ;
    }


    /**
     * 增加访问量        blog  ----已测试
     */
    @PostMapping("addVisitorCount")
    public JsonResult updateVisitorCount(){
        int i = siteInfoService.updateVisitorCount();
        return ResultUtils.successExecute(i) ;
    }

}
