package com.xianqingzao.yequxiaoquan.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xianqingzao.yequxiaoquan.common.FirstValidGroup;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.common.SecondValidGroup;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.User;
import com.xianqingzao.yequxiaoquan.pojo.Role;
import com.xianqingzao.yequxiaoquan.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class OperatorController {

    @Autowired
    private OperatorService operatorServicee;

    @RequestMapping(value = "/operator", method = RequestMethod.GET)
    public RestfulResult findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,
                                                    @RequestParam(value = "search", required = false) String search,
                                                    @RequestParam(value = "status", required = false) String status) {
        Query query = new Query(pageNum, pageSize, search, status);
        Page<User> operators = operatorServicee.findByPage(query);
        PageInfo<User> pageInfo = new PageInfo<>(operators);
        return new RestfulResult(pageInfo);
    }

    @RequestMapping(value = "/operator/role", method = RequestMethod.GET)
    public RestfulResult<List<Role>> getAllRole() {
        List roleList = operatorServicee.getAllRole();
        return new RestfulResult(roleList);
    }

    @RequestMapping(value = "/operator/disable", method = RequestMethod.PUT)
    public RestfulResult disable(@RequestBody List<Integer> idList) {
        operatorServicee.disable(idList);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/operator/enable", method = RequestMethod.PUT)
    public RestfulResult enable(@RequestBody List<Integer> idList) {
        operatorServicee.enable(idList);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/operator/{id}/password", method = RequestMethod.PUT)
    // @Validated 是Spring对@Valid的封装，有对属性的分组功能
    public RestfulResult resetPwd(@PathVariable("id") String id, @Validated({FirstValidGroup.class}) @RequestBody User user) {
        operatorServicee.resetPwd(id, user.getPwd());
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/operator/{id}", method = RequestMethod.PUT)
    public RestfulResult alter(@PathVariable("id") String id, @Validated({SecondValidGroup.class}) @RequestBody User user) {
        operatorServicee.alter(id, user.getUsername(), user.getRoleIds());
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/operator", method = RequestMethod.POST)
    // @Valid 来自hibernate-validator，没有对属性的分组功能
    public RestfulResult add(@Valid @RequestBody User user, @SessionAttribute("userDetail") User creator) {
        operatorServicee.add(creator.getId(), user);
        return new RestfulResult(null);
    }
}
