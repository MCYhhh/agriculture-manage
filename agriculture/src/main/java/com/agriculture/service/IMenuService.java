package com.agriculture.service;

import com.agriculture.entity.Menu;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
public interface IMenuService extends IService<Menu> {
    List<Menu> findMenus(String name);

    IPage<Menu> selectPage(Page<Menu> spage, QueryWrapper<Menu> queryWrapper);
}
