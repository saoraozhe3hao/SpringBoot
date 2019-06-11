package com.xianqingzao.yequxiaoquan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianqingzao.yequxiaoquan.dao.ReportDao;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.Record;
import com.xianqingzao.yequxiaoquan.pojo.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReportService {
    @Autowired
    private ReportDao reportDao;

    public Page findByPage(Query query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        Page page = reportDao.findByPage(query);
        return page;
    }

    public void reply(Record record) {
        record.setType("reply");
        reportDao.record(record);
    }

    @Transactional
    public void conduct(Record record) {
        record.setType("conduct");
        reportDao.record(record);
        reportDao.changeStatus(record.getReportId(), record.getReportStatus());
    }

}

