package com.example.seckill.controller;

//秒杀

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.seckill.pojo.Order;
import com.example.seckill.pojo.SeckillOrder;
import com.example.seckill.pojo.User;
import com.example.seckill.service.IGoodsService;
import com.example.seckill.service.IOrderService;
import com.example.seckill.service.ISeckillOrderService;
import com.example.seckill.vo.GoodsVo;
import com.example.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ISeckillOrderService seckillOrderService;
    @Autowired
    private IOrderService orderService;

//    Windows优化前QPS：1136.8/sec
//    Linux优化前QPS：418.4/sec

//    秒杀
    @RequestMapping("/doSeckill")
    public String doSeckill(Model model, User user, Long goodsId){
//        判断登录
        if (user == null){
            return "login";
        }
        model.addAttribute("user", user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);

//        判断库存
        if (goods.getStockCount() < 1){
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
            return "seckillFail";
        }

//        判断重复抢购
        SeckillOrder seckillOrder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>().eq("user_id", user.getId())
                .eq("goods_id", goodsId));
        if (seckillOrder != null){
            model.addAttribute("errmsg", RespBeanEnum.REPEAT_ERROR);
            return "seckillFail";
        }

        Order order = orderService.seckill(user, goods);
        model.addAttribute("order", order);
        model.addAttribute("goods", goods);
        return "orderDetail";
    }
}
