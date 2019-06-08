package com.xianqingzao.yequxiaoquan.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.User;
import com.xianqingzao.yequxiaoquan.pojo.Role;
import com.xianqingzao.yequxiaoquan.pojo.User;
import com.xianqingzao.yequxiaoquan.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class OperatorController {

    @Autowired
    private OperatorService operatorServicee;

    @RequestMapping(value = "/operator", method = RequestMethod.GET)
    public RestfulResult<PageInfo<User>> findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,
                                                    @RequestParam(value = "search", required = false) String search,
                                                    @RequestParam(value = "status", required = false) String status) {
        Query query = new Query(pageNum, pageSize, search);
        query.setStatus(status);
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
    public RestfulResult resetPwd(@PathVariable("id") String id, @RequestBody Map<String, String> map) {
        operatorServicee.resetPwd(id, map.get("password"));
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/operator/{id}", method = RequestMethod.PUT)
    public RestfulResult alter(@PathVariable("id") String id, @RequestBody Map<String, Object> map) {
        String username = (String) map.get("username");
        List roleIds = (List<String>) map.get("roleIds");
        operatorServicee.alter(id, username, roleIds);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/operator", method = RequestMethod.POST)
    public RestfulResult add(@RequestBody User user, @SessionAttribute("userDetail") User creator) {
        operatorServicee.add(creator.getId(), user);
        return new RestfulResult(null);
    }
}