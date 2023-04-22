package com.agriculture.service.impl;

import com.agriculture.entity.Scenery;
import com.agriculture.mapper.SceneryMapper;
import com.agriculture.service.ISceneryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 景区表 服务实现类
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Service
public class SceneryServiceImpl extends ServiceImpl<SceneryMapper, Scenery> implements ISceneryService {

    @Resource
    SceneryMapper sceneryMapper;
    @Override
    public List<Scenery> selectList(QueryWrapper<Scenery> queryWrapper) {
        return sceneryMapper.selectList(queryWrapper);
    }
}
