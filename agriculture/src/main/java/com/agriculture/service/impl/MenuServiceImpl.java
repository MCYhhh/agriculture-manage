package com.agriculture.service.impl;

import com.agriculture.entity.Menu;
import com.agriculture.mapper.MenuMapper;
import com.agriculture.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
