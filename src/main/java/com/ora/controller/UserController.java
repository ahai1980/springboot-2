package com.ora.controller;

import com.ora.result.GlobalErrorInfoEnum;
import com.ora.result.GlobalErrorInfoException;
import com.ora.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import com.ora.model.User;
import com.ora.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

@Api(value = "用户相关的接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
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
    /*public String add(@RequestBody User user)
        return "hello " + userService.add(user);
    }*/
    public Result add(@RequestBody User user) {
        logger.info("Enter addUser.........................");
        return new Result(userService.add(user));
    }

    /**
     * 根据主键查询用户
     *
     * @return User
     * @since 2016年9月22日20:32:43
     */
    @RequestMapping("/view/{id}")
    @ApiOperation(notes = "查询用户", value = "查询单个用户", httpMethod = "GET")
    /*
    public User getCountryById(@PathVariable Integer id) {
        return userService.findByUserId(id);
    }*/
    public Result getUserById(@PathVariable Integer id) throws GlobalErrorInfoException {
        /*if (id.equals(null)) {
            throw new GlobalErrorInfoException(UserErrorInfoEnum.PARAMS_NO_COMPLETE);
        }*/
        logger.info("Enter getUserById.........................");
        return new Result(userService.findByUserId(id));
    }


    /**
     * 查询所有用户
     *
     * @return List<User>
     */
    @ApiOperation(value = "获取用户列表", notes = "获取用户列表", httpMethod = "GET")
    @RequestMapping(value = {"/list"})
    public Result getUserList() {
        List<User> userList = userService.findAll();
        //return userList;
        logger.info("Enter getUserList.........................");
        return new Result(userList);
    }

    @ApiOperation(value = "删除用户", notes = "删除用户", httpMethod = "POST")
    @RequestMapping(value = "/delete/{id}")
    /*public Boolean deleteUser(@PathVariable Integer id) {
        boolean result;
        if (userService.findByUserId(id) != null) {
            result = userService.deleteUserByUserId(id) > 0;
        } else {
            result = false;
        }
        return result;
    }*/
    public Result deleteUser(@PathVariable Integer id) {
        if (userService.findByUserId(id) != null) {
            logger.info("User Found and doing deleteUser.........................");
            return new Result(userService.deleteUserByUserId(id));
        }else{
            return new Result(GlobalErrorInfoEnum.NOT_FOUND);
        }
    }
}
