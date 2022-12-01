package xyz.hy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.hy.common.api.CommonPage;
import xyz.hy.common.api.CommonResult;
import xyz.hy.model.SysUser;
import xyz.hy.service.UserService;

import java.util.List;

/**
 * @author ：hongyan
 * @date ：Created in 2022/12/1 19:24
 * @description：UserController
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 增加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<SysUser> insertUser(@RequestBody SysUser user) {
        CommonResult<SysUser> result = null;
        Integer res  = userService.insertUser(user);
        if (res.equals(1)) {
            result = CommonResult.success(user);
        } else {
            result = CommonResult.failed("插入用户失败");
        }
        return result;
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult deleteUserById(@RequestParam Long userId) {
        CommonResult result = null;
        Integer res = userService.deleteUser(userId);
        if (res.equals(1)) {
            result = CommonResult.success(null);
        } else {
            result = CommonResult.failed();
        }
        return result;
    }

    /**
     * 根据id更新用户信息
     * @param id
     * @param user
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<SysUser> updateUser(@RequestParam Long id, @RequestBody SysUser user) {
        CommonResult<SysUser> result = null;
        Integer res = userService.updateUserById(id, user);
        if (res.equals(1)) {
            result = CommonResult.success(user);
        } else {
            result = CommonResult.failed("更新用户失败");
        }
        return result;
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "select", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<SysUser> selectUserById(@RequestParam Long id) {
        CommonResult<SysUser> result = null;
        SysUser res = userService.selectUserById(id);
        if (res != null) {
            result = CommonResult.success(res);
        } else {
            result = CommonResult.failed("查无此用户");
        }
        return result;
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SysUser>> listAllUsers(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<SysUser> userList = userService.listUsers(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(userList));
    }
}
