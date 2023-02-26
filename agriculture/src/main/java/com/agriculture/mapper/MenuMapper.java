package com.agriculture.mapper;

import com.agriculture.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
//    List<String> selectMtitleByUid(Integer uid);

}
