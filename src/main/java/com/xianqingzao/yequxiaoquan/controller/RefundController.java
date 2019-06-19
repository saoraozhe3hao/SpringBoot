package com.xianqingzao.yequxiaoquan.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.Record;
import com.xianqingzao.yequxiaoquan.pojo.User;
import com.xianqingzao.yequxiaoquan.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class RefundController {

    @Autowired
    private RefundService refundService;

    @RequestMapping(value = "/refund", method = RequestMethod.GET)
    public RestfulResult findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,
                                                    @RequestParam(value = "search", required = false) String search,
                                                    @RequestParam(value = "status", required = false) String status) {
        Query query = new Query(pageNum, pageSize, search, status);
        Page page = refundService.findByPage(query);
        PageInfo pageInfo = new PageInfo(page);
        return new RestfulResult(pageInfo);
    }

    @RequestMapping(value = "/refund/{id}/reply", method = RequestMethod.PUT)
    public RestfulResult reply(@PathVariable("id") String reportId, @Validated @RequestBody Record record, @SessionAttribute("userDetail") User operator) {
        record.setReportId(reportId);
        record.setOperatorId(operator.getId());
        refundService.reply(record);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/refund/{id}/accept", method = RequestMethod.PUT)
    public RestfulResult accept(@PathVariable("id") String reportId, @SessionAttribute("userDetail") User operator) {
        Record record = new Record(operator.getId(),reportId);
        refundService.accept(record);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/refund/{id}/conduct", method = RequestMethod.PUT)
    public RestfulResult conduct(@PathVariable("id") String reportId, @Validated @RequestBody Record record, @SessionAttribute("userDetail") User operator) {
        record.setReportId(reportId);
        record.setOperatorId(operator.getId());
        refundService.conduct(record);
        return new RestfulResult(null);
    }
}
