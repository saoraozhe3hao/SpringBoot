package com.xianqingzao.yequxiaoquan.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.pojo.Message;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.Reply;
import com.xianqingzao.yequxiaoquan.pojo.User;
import com.xianqingzao.yequxiaoquan.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class MessageController {

    @Autowired
    private MessageService messageServicee;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public RestfulResult findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,
                                                    @RequestParam(value = "search", required = false) String search,
                                                    @RequestParam(value = "status", required = false) String status) {
        Query query = new Query(pageNum, pageSize, search, status);
        Page page = messageServicee.findByPage(query);
        PageInfo pageInfo = new PageInfo(page);
        return new RestfulResult(pageInfo);
    }

    @RequestMapping(value = "/message/{id}/reply", method = RequestMethod.PUT)
    public RestfulResult reply(@PathVariable("id") String messageId, @Validated @RequestBody Reply reply, @SessionAttribute("userDetail") User operator) {
        reply.setMessageId(messageId);
        reply.setOperatorId(operator.getId());
        messageServicee.reply(reply);
        return new RestfulResult(null);
    }
}
