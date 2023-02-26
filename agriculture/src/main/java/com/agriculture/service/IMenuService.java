package com.agriculture.service;

import com.agriculture.entity.Menu;
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
}
