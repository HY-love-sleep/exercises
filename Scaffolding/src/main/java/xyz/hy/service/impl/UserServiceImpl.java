package xyz.hy.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hy.mapper.SysUserMapper;
import xyz.hy.model.SysUser;
import xyz.hy.model.SysUserExample;
import xyz.hy.service.UserService;

import java.util.List;

/**
 * @author ：hongyan
 * @date ：Created in 2022/12/1 19:03
 * @description：用户实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper userMapper;
    @Override
    public Integer insertUser(SysUser user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer deleteUser(Long userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public Integer updateUserById(Long userId, SysUser user) {
        user.setUserId(userId);
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public SysUser selectUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<SysUser> listUsers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectByExample(new SysUserExample());
    }
}
