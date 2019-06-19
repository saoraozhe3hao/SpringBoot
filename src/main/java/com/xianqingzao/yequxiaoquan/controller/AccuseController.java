package com.xianqingzao.yequxiaoquan.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.pojo.*;
import com.xianqingzao.yequxiaoquan.service.AccuseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AccuseController {

    @Autowired
    private AccuseService accuseService;

    @RequestMapping(value = "/accuse", method = RequestMethod.GET)
    public RestfulResult findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,
                                                    @RequestParam(value = "search", required = false) String search,
                                                    @RequestParam(value = "status", required = false) String status) {
        Query query = new Query(pageNum, pageSize, search, status);
        Page page = accuseService.findByPage(query);
        PageInfo pageInfo = new PageInfo(page);
        return new RestfulResult(pageInfo);
    }

    @RequestMapping(value = "/accuse/{id}/reply", method = RequestMethod.PUT)
    public RestfulResult reply(@PathVariable("id") String reportId, @Validated @RequestBody Record record, @SessionAttribute("userDetail") User operator) {
        record.setReportId(reportId);
        record.setOperatorId(operator.getId());
        accuseService.reply(record);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/accuse/{id}/conduct", method = RequestMethod.PUT)
    public RestfulResult conduct(@PathVariable("id") String reportId, @Validated @RequestBody Record record, @SessionAttribute("userDetail") User operator) {
        record.setReportId(reportId);
        record.setOperatorId(operator.getId());
        accuseService.conduct(record);
        return new RestfulResult(null);
    }
}
