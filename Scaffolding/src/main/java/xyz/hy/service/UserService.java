package xyz.hy.service;

import org.springframework.stereotype.Service;
import xyz.hy.model.SysUser;

import java.util.List;

/**
 * @author ：hongyan
 * @date ：Created in 2022/12/1 18:58
 * @description：UserService
 */
@Service
public interface UserService {
    Integer insertUser(SysUser user);

    Integer deleteUser(Long userId);

    Integer updateUserById(Long userId, SysUser user);

    SysUser selectUserById(Long userId);

    List<SysUser> listUsers(int pageNum, int pageSize);
}
