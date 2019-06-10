package com.xianqingzao.yequxiaoquan.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xianqingzao.yequxiaoquan.common.FirstValidGroup;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.common.SecondValidGroup;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.Role;
import com.xianqingzao.yequxiaoquan.pojo.User;
import com.xianqingzao.yequxiaoquan.service.OperatorService;
import com.xianqingzao.yequxiaoquan.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public RestfulResult findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,
                                                    @RequestParam(value = "search", required = false) String search,
                                                    @RequestParam(value = "status", required = false) String status) {
        Query query = new Query(pageNum, pageSize, search, status);
        Page<User> operators = roleService.findByPage(query);
        PageInfo<User> pageInfo = new PageInfo(operators);
        return new RestfulResult(pageInfo);
    }

    @RequestMapping(value = "/role/authority", method = RequestMethod.GET)
    public RestfulResult getAllAuthority() {
        List roleList = roleService.getAllAuthority();
        return new RestfulResult(roleList);
    }

    @RequestMapping(value = "/role/disable", method = RequestMethod.PUT)
    public RestfulResult disable(@RequestBody List<Integer> idList) {
        roleService.disable(idList);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/role/enable", method = RequestMethod.PUT)
    public RestfulResult enable(@RequestBody List<Integer> idList) {
        roleService.enable(idList);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/role/{id}", method = RequestMethod.PUT)
    public RestfulResult alter(@PathVariable("id") String id, @Validated @RequestBody Role role) {
        roleService.alter(id, role.getName(), role.getAuthorityIds());
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public RestfulResult add(@Valid @RequestBody Role role) {
        roleService.add(role);
        return new RestfulResult(null);
    }
}
