package com.example.seckill.controller;


import com.example.seckill.pojo.User;
import com.example.seckill.vo.RespBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author littlered
 * @since 2022-12-02
 */
@Controller
@RequestMapping("/user")
public class UserController {

//    用户信息测试
    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(User user){
        return RespBean.success(user);
    }

}
