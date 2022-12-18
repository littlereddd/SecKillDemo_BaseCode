package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.Goods;
import com.example.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author littlered
 * @since 2022-12-05
 */
public interface IGoodsService extends IService<Goods> {

    //    获取商品列表
    List<GoodsVo> findGoodsVo();

//    获取商品详情
    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
