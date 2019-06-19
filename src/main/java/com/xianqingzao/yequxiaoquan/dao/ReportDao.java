package com.xianqingzao.yequxiaoquan.dao;

import com.github.pagehelper.Page;
import com.xianqingzao.yequxiaoquan.pojo.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDao {
    Page findByPage(Query query);

    public List getRecordsByReportId(String reportId);

    Report findById(String id);

    void record(Record record);

    void changeStatus(String id, String status);
}
