package com.agriculture.controller;


import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.entity.Scenery;
import com.agriculture.service.ISceneryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 景区表 前端控制器
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@RestController
@RequestMapping("/scenery")
public class SceneryController {
    @Resource
    ISceneryService iSceneryService;

    @PostMapping("/save")
    public Result save(@RequestBody Scenery scenery){
        for(Scenery a:iSceneryService.list()) {
            if(scenery.getSname().equals(a.getSname())) {
                return Result.error(HttpCode.USER_System.code(),"参数错误，景区已存在");
            }
        }
        return Result.success(iSceneryService.save(scenery));
    }
}
