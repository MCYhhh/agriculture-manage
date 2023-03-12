package com.agriculture.mapper;

import com.agriculture.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select rid from role where rtype = #{rtype}")
    Integer selectByRtype(@Param("rtype") Integer rtype);

}
