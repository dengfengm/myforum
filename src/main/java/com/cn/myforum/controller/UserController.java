package com.cn.myforum.controller;

import com.cn.redis.config.RedisService;
import com.cn.myforum.bean.UserBean;
import com.cn.myforum.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisService redis;

    @RequestMapping(value="/getuser")
    public List<UserBean> getUsers() {
        List<UserBean> userList = userMapper.getUsers();
        String name = (String) redis.get("1000");
        System.out.println("-----------------------------" + name + "-----------------------------");
        return userList;
    }

    @RequestMapping(value="/update/{id}")
    public List<UserBean> update(@PathVariable String id) {
        UserBean user=new UserBean();
        user.setUserId(id);
        user.setUserName("updateName");
        redis.set(id,user.getUserName());
        userMapper.update(user);
        return userMapper.getUsers();

    }

    @RequestMapping(value="/del/{id}")
    public List<UserBean> del(@PathVariable String id){
        userMapper.del(id);
        return userMapper.getUsers();
    }

    @RequestMapping(value="add")
    public List<UserBean> add(){
        UserBean user=new UserBean();
        user.setUserName("test");
        userMapper.save(user);
        return userMapper.getUsers();
    }

}
