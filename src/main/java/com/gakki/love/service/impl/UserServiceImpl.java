package com.gakki.love.service.impl;

import com.gakki.love.domain.User;
import com.gakki.love.repository.UserRepository;
import com.gakki.love.util.EncryptUtil;
import com.gakki.love.util.IntegerUtil;
import com.gakki.love.util.MailUtils;
import com.gakki.love.util.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 林漠
 * \* Date: 2017/9/14
 * \* Time: 0:14
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Slf4j
@Service
public class UserServiceImpl implements com.gakki.love.service.UserService {
    @Resource
    private UserRepository userRepository;

    /*
    获取分页信息
     */
    @Override
    @Transactional(readOnly = true)
    public Pagination<User> getTopPeople(int page, int size){
        page -= 1;
        int start = page * size;
        List<User> users = userRepository.getByIdJoinTopicUserId(start,size);
        int count = (int) userRepository.count();
        Pagination<User> pageUser = new Pagination<>(users,page,size,count);
        return pageUser;

    }
    /*
    登录
     */

    @Override
    @Transactional(readOnly = true)
    public User login(User user){
        User u = null;
        if (user.getUsername() != null){
            u = userRepository.getByUsernameAndPassword(user.getUsername(),user.getPassword());
        }else {
            u = userRepository.getByEmailAndPassword(user.getEmail(),user.getPassword());
        }
        return u != null ? u :new User();
    }
    /*
    更新用户信息
     */

    @Override
    @Transactional
    public boolean newOrUpdate(User user){

        return IntegerUtil.isPositiveValue(userRepository.saveAndFlush(user).getId());
    }

    /*
    查找用户Id
     */

    @Override
    @Transactional(readOnly = true)
    public User getById(Integer id){
        return userRepository.getById(id);
    }
    /*
    按用户名查找
     */

    @Override
    @Transactional(readOnly = true)
    public User getByName(String username){

        if (MailUtils.isMail(username)){
            return userRepository.getByEmail(EncryptUtil.execEncrypt(username));
        }
        return userRepository.getByUsername(username);
    }

    /*
    更新用户头像
     */

    @Override
    @Transactional
    public void updateHead(User user){
        userRepository.saveAndFlush(user);
    }

    /*
    按email查找
     */

    @Override
    @Transactional(readOnly = true)
    public User getByEmail(String email){

        return userRepository.getByEmail(email);
    }

}
