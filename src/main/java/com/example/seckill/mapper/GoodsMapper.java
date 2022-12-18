package com.example.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seckill.pojo.Goods;
import com.example.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author littlered
 * @since 2022-12-05
 */
public interface GoodsMapper extends BaseMapper<Goods> {

//    获取商品列表
    List<GoodsVo> findGoodsVo();

    //    获取商品详情
    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
