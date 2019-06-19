package com.xianqingzao.yequxiaoquan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianqingzao.yequxiaoquan.dao.ReportDao;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.Record;
import com.xianqingzao.yequxiaoquan.pojo.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccuseService {
    @Autowired
    private ReportDao reportDao;
    private String reportCategory = "accuse";

    public Page findByPage(Query query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        query.setCategory(reportCategory);
        Page page = reportDao.findByPage(query);
        return page;
    }

    public void reply(Record record) {
        Report report = reportDao.findById(record.getReportId());
        // 本接口只能操作 商户举报类型 的report
        if(reportCategory.equals(report.getCategory())){
            record.setType("reply");
            reportDao.record(record);
        }
    }

    @Transactional
    public void conduct(Record record) {
        Report report = reportDao.findById(record.getReportId());
        // 本接口只能操作 商户举报类型 的report
        if(reportCategory.equals(report.getCategory())){
            record.setType("conduct");
            reportDao.record(record);
            reportDao.changeStatus(record.getReportId(), record.getReportStatus());
        }
    }

}

