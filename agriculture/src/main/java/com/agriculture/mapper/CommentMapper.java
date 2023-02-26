package com.agriculture.mapper;

import com.agriculture.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
