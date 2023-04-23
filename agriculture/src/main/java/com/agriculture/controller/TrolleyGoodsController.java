package com.agriculture.controller;
import com.agriculture.common.Result;
import com.agriculture.config.mybatis.TrolleyGoodsPage;
import com.agriculture.entity.vo.TrolleyGoodsVo;
import com.agriculture.service.ITrolleyService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/trolleyGoods")
public class TrolleyGoodsController {
    @Resource
    private ITrolleyService iTrolleyService;

    @PostMapping("/findAll")
    public Result findAll(@RequestBody TrolleyGoodsPage trolleyGoodsPage){
        Page<TrolleyGoodsVo> iPage = new Page<TrolleyGoodsVo>(trolleyGoodsPage.getPage(),trolleyGoodsPage.getSize());
        return Result.success(iTrolleyService.getTrolleyGoodsPageVo(iPage));
    }
}
