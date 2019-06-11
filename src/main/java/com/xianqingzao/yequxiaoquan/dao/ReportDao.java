package com.xianqingzao.yequxiaoquan.dao;

import com.github.pagehelper.Page;
import com.xianqingzao.yequxiaoquan.pojo.Message;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.Record;
import com.xianqingzao.yequxiaoquan.pojo.Reply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDao {
    Page findByPage(Query query);

    public List getRecordsByReportId(String reportId);

    void record(Record record);

    void changeStatus(String id, String status);
}
