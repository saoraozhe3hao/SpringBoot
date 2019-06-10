package com.xianqingzao.yequxiaoquan.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xianqingzao.yequxiaoquan.common.FirstValidGroup;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.common.SecondValidGroup;
import com.xianqingzao.yequxiaoquan.pojo.Message;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.User;
import com.xianqingzao.yequxiaoquan.service.MessageService;
import com.xianqingzao.yequxiaoquan.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        Page<Message> messages = messageServicee.findByPage(query);
        PageInfo<User> pageInfo = new PageInfo(messages);
        return new RestfulResult(pageInfo);
    }

    @RequestMapping(value = "/message/role", method = RequestMethod.GET)
    public RestfulResult getAllRole() {
        List roleList = messageServicee.getAllRole();
        return new RestfulResult(roleList);
    }

    @RequestMapping(value = "/message/disable", method = RequestMethod.PUT)
    public RestfulResult disable(@RequestBody List<Integer> idList) {
        messageServicee.disable(idList);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/message/enable", method = RequestMethod.PUT)
    public RestfulResult enable(@RequestBody List<Integer> idList) {
        messageServicee.enable(idList);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/message/{id}/password", method = RequestMethod.PUT)
    // @Validated 是Spring对@Valid的封装，有对属性的分组功能
    public RestfulResult resetPwd(@PathVariable("id") String id, @Validated({FirstValidGroup.class}) @RequestBody User user) {
        messageServicee.resetPwd(id, user.getPwd());
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/message/{id}", method = RequestMethod.PUT)
    public RestfulResult alter(@PathVariable("id") String id, @Validated({SecondValidGroup.class}) @RequestBody User user) {
        messageServicee.alter(id, user.getUsername(), user.getRoleIds());
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    // @Valid 来自hibernate-validator，没有对属性的分组功能
    public RestfulResult add(@Valid @RequestBody User user, @SessionAttribute("userDetail") User creator) {
        messageServicee.add(creator.getId(), user);
        return new RestfulResult(null);
    }
}
