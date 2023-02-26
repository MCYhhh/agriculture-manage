package com.agriculture.mapper;


import com.agriculture.entity.Administrate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户菜单表 Mapper 接口
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Mapper
public interface AdministrateMapper extends BaseMapper<Administrate> {

    @Select("select mid from administrate where rid = #{rid}")
    List<Integer> selectByRoleId(@Param("rid")Integer rid);

}
