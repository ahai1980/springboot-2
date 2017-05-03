package com.ora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.ora.model.User;
import com.ora.service.UserService;

import java.util.*;

@Api(value = "用户相关的接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    /**
     * 添加用户
     *
     * @param user 用户对象
     * @since 2016年9月21日21:01:50
     */
    @RequestMapping("/add")
    @ApiOperation(notes = "添加用户", value = "添加一个用户", httpMethod = "POST")
    /*
	@ApiImplicitParams({
		@ApiImplicitParam(name="nickname",paramType="query",dataType="string"),
		@ApiImplicitParam(name="password",paramType="query",dataType="string")
	})*/
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    public String add(@RequestBody User user) {
        return "hello " + userService.add(user);
    }

    /**
     * 查询所有用户
     *
     * @return User
     * @since 2016年9月22日20:32:43
     */
    @RequestMapping("/view/{id}")
    @ApiOperation(notes = "查询用户", value = "查询单个用户", httpMethod = "GET")
    public User getCountryById(@PathVariable Integer id) {
        return userService.findByUserId(id);
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> userList = userService.findAll();
        return userList;
    }
}
