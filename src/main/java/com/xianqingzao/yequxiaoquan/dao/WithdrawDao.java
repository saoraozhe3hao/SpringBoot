package com.xianqingzao.yequxiaoquan.dao;

import com.github.pagehelper.Page;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WithdrawDao {
    Page findByPage(Query query);

    public List getRecordsByReportId(String reportId);

    void handling(String operatorId, String withdrawId);

    void paid(String operatorId, String withdrawId);

    void deductBalance(String withrowId);
}
