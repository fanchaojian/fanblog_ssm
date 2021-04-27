package com.fanchaojian.service.impl;

import com.fanchaojian.dao.SiteInfoMapper;
import com.fanchaojian.pojo.SiteInfo;
import com.fanchaojian.service.ISiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fanchaojian
 * @date 2021-4-21 - 16:31
 */
@Service
public class SiteInfoServiceImpl implements ISiteInfoService {

    @Autowired
    private SiteInfoMapper siteInfoMapper ;

    @Override
    public SiteInfo getSiteInfo() {
        return siteInfoMapper.getSiteInfo();
    }

    @Override
    public int updateSiteInfo(SiteInfo siteInfo) {
        int i = siteInfoMapper.updateSiteInfo(siteInfo);
        return i ;
    }

    @Override
    public int updateVisitorCount() {
        SiteInfo siteInfo = getSiteInfo();
        return siteInfoMapper.updateVisitorCount(siteInfo.getSiteId()) ;
    }
}
