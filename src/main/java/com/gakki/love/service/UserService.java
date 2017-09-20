package com.gakki.love.service;

import com.gakki.love.domain.User;
import com.gakki.love.util.Pagination;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    /*

     * 获取用户,按分享的数量排序
     * @param page 当前页号
     * @param 每页记录数
     * @return 用户的分页记录
     */

    @Transactional(readOnly = true)
    Pagination<User> getTopPeople(int page, int size);

    /**
     * 用户登录
     * @param user 用户
     * @return 返回登录用户信息
     */
    @Transactional(readOnly = true)
    User login(User user);

    /**
     * regist or update an user.
     * @param user the user
     * @return true,if success
     */
    @Transactional
    boolean newOrUpdate(User user);

    /**
     * 通过UID获取用户
     * @param id 用户UID
     * @return 返回一个用户
     */
    @Transactional(readOnly = true)
    User getById(Integer id);

    /**
     * 通过用户名获取用户
     * @param username 用户名或邮箱
     * @return 返回一个用户
     */
    @Transactional(readOnly = true)
    User getByName(String username);


    /**
     * 更新用户头像
     * @param user 要更新的用户
     */

    @Transactional
    void updateHead(User user);

    /**
     * 通过邮箱获取用户
     *
     * @param email the email
     * @return the by email
     */
    @Transactional(readOnly = true)
    User getByEmail(String email);
}
