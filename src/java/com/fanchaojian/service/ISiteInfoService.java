package com.fanchaojian.service;

import com.fanchaojian.pojo.SiteInfo;

/**
 * @author fanchaojian
 * @date 2021-4-21 - 16:31
 */
public interface ISiteInfoService {
    /*站点信息，默认为第一个blogAdmin对应的站点*/
    SiteInfo getSiteInfo() ;

    /*修改基本信息*/
    int updateSiteInfo(SiteInfo siteInfo) ;

    /*增加网站访问量*/
    int updateVisitorCount() ;
}
