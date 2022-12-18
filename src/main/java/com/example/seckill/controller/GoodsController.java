package com.example.seckill.controller;

import com.example.seckill.pojo.User;
import com.example.seckill.service.IGoodsService;
import com.example.seckill.service.IUserService;
import com.example.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IGoodsService goodsService;

//    Windows优化前QPS：1402.1 /sec
//    Linux优化前： /sec

//    跳转商品列表页
    @RequestMapping("/toList")
    public String toList(Model model, User user){

//        if (StringUtils.isEmpty(ticket)){
//            return "login";
//        }
//
////        User user = ((User)session.getAttribute(ticket));
//        User user = userService.getUserByCookie(ticket, request, response);
//        if (user == null) {
//            return "login";
//        }
        model.addAttribute("user", user);
        model.addAttribute("goodsList",goodsService.findGoodsVo());
        return "goodsList";
    }

    //    跳转商品详情页
    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable Long goodsId){

        model.addAttribute("user", user);
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);

//        秒杀时间判断
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();
        int seckillStatus = 0;//秒杀状态，默认倒计时
        int remainSeconds = 0;//秒杀倒计时
        if (nowDate.before(startDate)){
//            倒计时
            remainSeconds = (int) ((startDate.getTime() - nowDate.getTime()) / 1000);
        } else if (nowDate.after(endDate)) {
//            已结束
            seckillStatus = 2;
            remainSeconds = -1;
        }else {
//            进行中
            seckillStatus = 1;
            remainSeconds = 0;

        }
        model.addAttribute("remainSeconds", remainSeconds);
        model.addAttribute("seckillStatus", seckillStatus);
        model.addAttribute("goods", goodsVo);
        return "goodsDetail";
    }
}
