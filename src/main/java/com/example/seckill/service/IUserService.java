package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.User;
import com.example.seckill.vo.LoginVo;
import com.example.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author littlered
 * @since 2022-12-02
 */
public interface IUserService extends IService<User> {

//    登录
    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

//    根据cookie获取用户
    User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response);
}
