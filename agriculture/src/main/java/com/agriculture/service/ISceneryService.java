package com.agriculture.service;
import com.agriculture.entity.Scenery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * <p>
 * 景区表 服务类
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
public interface ISceneryService extends IService<Scenery> {

    List<Scenery> selectList(QueryWrapper<Scenery> queryWrapper);

    Page<Scenery> selectPage(Page<Scenery> page, QueryWrapper<Scenery> queryWrapper);
}
