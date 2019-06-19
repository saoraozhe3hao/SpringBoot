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
public class RefundService {
    @Autowired
    private ReportDao reportDao;
    private String reportCategory = "refund";

    public Page findByPage(Query query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        query.setCategory(reportCategory);
        Page page = reportDao.findByPage(query);
        return page;
    }

    public void reply(Record record) {
        Report report = reportDao.findById(record.getReportId());
        // 本接口只能操作 退款类型 的report
        if(reportCategory.equals(report.getCategory())){
            record.setType("reply");
            reportDao.record(record);
        }
    }

    @Transactional
    public void accept(Record record) {
        Report report = reportDao.findById(record.getReportId());
        // 本接口只能操作 退款类型 的report
        if(reportCategory.equals(report.getCategory()) && "pending".equals(report.getStatus())){
            record.setType("conduct");
            record.setReportStatus("handling");
            reportDao.record(record);
            reportDao.changeStatus(record.getReportId(), record.getReportStatus());
        }
    }

    @Transactional
    public void conduct(Record record) {
        Report report = reportDao.findById(record.getReportId());
        // 本接口只能操作 退款类型 的report
        if(reportCategory.equals(report.getCategory()) && "handling".equals(report.getStatus())){
            record.setType("conduct");
            reportDao.record(record);
            reportDao.changeStatus(record.getReportId(), record.getReportStatus());
        }
    }

}

