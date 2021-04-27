package com.fanchaojian.dao;

import com.fanchaojian.pojo.SiteInfo;
import org.springframework.stereotype.Repository;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 15:36
 */
@Repository
public interface SiteInfoMapper {
    /*站点信息，默认为第一个blogAdmin对应的站点*/
    SiteInfo getSiteInfo() ;

    /*修改基本信息*/
    int updateSiteInfo(SiteInfo siteInfo) ;

    /*增加网站访问量*/
    int updateVisitorCount(int siteId) ;
}
